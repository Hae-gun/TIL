package servicespring;

public class ProductService12 implements ProductService {

	ProductDAO dao;
		
		
	public void setDao(ProductDAO dao) {
			this.dao = dao;
		}


	@Override
	public ProductVO sell() {
		System.out.println("12���� 50% �������Դϴ�.");
//		ProductDAO dao = new ProductDAO();
		
		return dao.sell(0.5, 0);
	}
	
}
