package annotation.servicespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service12")
public class ProductService12 implements ProductService {

	@Autowired
	ProductDAO dao;

	@Override
	public ProductVO sell() {
		System.out.println("12���� 50% �������Դϴ�.");
//		ProductDAO dao = new ProductDAO();

		return dao.sell(0.5, 0);
	}

}
