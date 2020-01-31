package annotation.servicespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service05")
public class ProductService05 implements ProductService {

	@Autowired // <bean>�±� X -> @Repository �� ������� ��.
	ProductDAO dao;

	@Override
	public ProductVO sell() {
		System.out.println("5���� 30% �������Դϴ�.");
//		ProductDAO dao = new ProductDAO();

		return dao.sell(0.3, 1);
	}

}
