package javanetwork.multieroom.newthing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

// Thread에 의해서 공유되는 공용객체를 만들기 위한 class를 정의
class ChatSharedobject {
	// Thread에 의해서 공유되어야 하는 데이터.
	// 모든 클라이언트에 대한 Thread를 만들기위해 필요한 Runnable 객체 저장.
	List<ChatRunnable> clients = new ArrayList<ChatRunnable>();
	HashMap<String,ArrayList<String>> rooms = new HashMap();
	String broadRoom = "";
	// 이 데이터를 제어하기 위해서 필요한 method
	// 새로운 사용자가 접속했을때 clients안에 새로한 사용자에 대한 Runnable 객체를 저장.
	public void setBroadRoom(String broadRoom) {
		this.broadRoom = broadRoom;
	}
	public void add(ChatRunnable runnable) {
		clients.add(runnable);
	}

	// 사용자가 접속을 종료했을 때 client안에 있는 사용자를 삭제.
	public void remove(ChatRunnable runnable) {
		clients.remove(runnable);
	}
	

	// 클라이언트가 데이터를 보내줬을 때 채팅메시지를 Broadcast하는 method
	public void broadcast(String msg) {
		
		for (ChatRunnable client : clients) {
			client.getPr().println(msg);
			client.getPr().flush();
		}
	}
	
	public HashMap getroomList() {
		return this.rooms;
	}
	public void addRoomList(String rName) {
		rooms.put(rName, null);
	}
	public void addUser(String userName,String roomName) {
		rooms.get(roomName).add(userName);
	}
	public ArrayList<String> getUser(String rName){
		return rooms.get(rName);
	} 
	
	public String roomList() {
		return this.rooms.keySet().toString();
	}
	public void roomBroadcast() {
		
		String rName =rooms.keySet().toString()+"@roomList";
		System.out.println(rooms.keySet().toString());
		for(ChatRunnable client : clients) {
			client.getPr().println(rName);
			client.getPr().flush();
		}
	}
	public void roomMemberBroadcast(String rName) {
		String result = "";
		
		result = getUser(rName).toString()+"@userList";
		for(ChatRunnable client : clients) {
			client.getPr().println(result);
			client.getPr().flush();
		}
				
	}
	
	
}
class ChatRunnable implements Runnable {
	private Socket s;
	private ChatSharedobject shared;
	private BufferedReader br;
	private PrintWriter pr;
	private TextArea ta;
	
	ChatRunnable(Socket s, ChatSharedobject shared, TextArea ta) {
		this.s = s;
		this.shared = shared;
		this.ta = ta;
		try {
			this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			this.pr = new PrintWriter(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PrintWriter getPr() {
		return this.pr;
	}

	public void run() {
		String line = "";
		
		try {
			
			
			while ((line = br.readLine()) != null) {
				
				if (line.equals("@EXIT")) {
					break;
				}

				// 자신과 연결된 클라이언트만 문자열 전송하는 코드
//				pr.println(line);
//				pr.flush();
				// 모든 클라이언트에게 문자열을 전달하기위해 공용객체를 활용.
				
				printMSG(line);
				
				if(line.contains("@chat")) {
					
					if(line.split("@").length==3) {
						String room = line.split("@")[2];
						printMSG(room);
					}
					
					
					shared.broadcast(line);
				}else if(line.contains("@create")) {
					String rName = line.split("@")[0];
					
					shared.addRoomList(rName);
					shared.broadcast(line);
					if(!shared.getroomList().containsKey(rName)) {
						shared.addRoomList(rName);
						
					}
					
					
				}else if(line.contains("@roomList")) {
					shared.roomBroadcast();
				}else if(line.contains("@connRoom")) {
					
					shared.setBroadRoom(line);
//					line += "@userList:"+shared.getUser(rName);
					shared.broadcast(line);
				}else if(line.contains("@room")) {
					shared.setBroadRoom(line);
					shared.broadcast(line);
				}
				
				if(line.contains("@addUser")) {
					
					String user = line.split(",")[1].split("@")[0];
					String roomName = line.split(",")[0].split("@")[0];
					printMSG(user + ":"+roomName+"입장");
					shared.addUser(user, roomName);
					System.out.println("이거 안뜬다.");
				
				}
				
			}

		} catch (Exception e) {
		}
	}
	private void printMSG(String msg) {
		Platform.runLater(() -> {
			ta.appendText(msg + "\n");
		});
		
	}
}

public class newChatServer extends Application {
	
	private TextArea ta;
	private Button startBtn, stopBtn;
	private ExecutorService excutorService = Executors.newCachedThreadPool();
	// 공용객체 하나 생성.(공용객체는 Thread에 의해서 공유되는 객체. 1개만 존재.)
	private ChatSharedobject shared = new ChatSharedobject();

	ServerSocket server;

	private void printMSG(String msg) {
		Platform.runLater(() -> {
			ta.appendText(msg + "\n");
		});

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 처음 창이 화면에 뜰때 화면구성하는 용도로 사용.
		// 화면을 동서남북중앙으로 구성하는 BorderPane을 이용.
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);

		// TextArea를 생성해서 BorderPane의 중앙에 부착.
		ta = new TextArea();
		root.setCenter(ta);

		// 두개의 버튼을 각각 생성해서 화면에 부착.
		startBtn = new Button("Echo Server 시작");
		startBtn.setPrefSize(150, 40);
		startBtn.setOnAction(e -> {
			// Event 처리코드
			printMSG("[서버시작]");
			// 별도의 Thread를 만들어서 서버역할을 수행해야 한다.
			// Runnable interface를 구현한 객체를 만들어서
			// ExecutorService(Thread Pool)을 이용하여 Thread를 실행.
			Runnable runnable = () -> {

				try {
					server = new ServerSocket(9999);
					while (true) {
						Socket s = server.accept();
						ChatRunnable chat = new ChatRunnable(s, shared,ta);
						// 새로운 사용자 추가.
						shared.add(chat);
						excutorService.execute(chat);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			};

			excutorService.execute(runnable); // Thread 실행.
			startBtn.setDisable(true);
		});

		stopBtn = new Button("Echo Server 중지");
		stopBtn.setPrefSize(150, 40);
		stopBtn.setOnAction(e -> {
			// Event 처리코드
			startBtn.setDisable(false);
		});

		// Android 의 LinearLayout과 유사한 component
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 40);
		// 위아래좌우 Insets 객체를 이용하여Padding 설정
		flowpane.setPadding(new Insets(10, 10, 10, 10));
		// 간격설정
		flowpane.setHgap(10);
		// 버튼 부착
		flowpane.getChildren().add(startBtn);
		flowpane.getChildren().add(stopBtn);
		// 판 부착
		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("서버용 JavaFX");

		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});

		primaryStage.show();

	}

	public static void main(String[] args) {
		launch();
	}
}
