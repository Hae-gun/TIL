package servicespring;

public class ProductServiceNo implements ProductService {

	ProductDAO dao;
		
		
	public void setDao(ProductDAO dao) {
			this.dao = dao;
		}


	@Override
	public ProductVO sell() {
		System.out.println("�����Ǹ� ���Դϴ�.");
//		ProductDAO dao = new ProductDAO();
		
		return dao.sell(0.0, 5);
	}
	
}
