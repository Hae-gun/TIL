package annotation.servicespring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	@Autowired // �̸��� �߿����� �ʴ�. ProductVO ��ü ������ �޾ƿ�.
	ProductVO vo;

	public ProductVO sell(double sale, int coupon) {
		// ProductVO vo = new ProductVO();
		// vo.setCode(100);
		// vo.setName("��Ƽ��ǻ��");
		// vo.setPrice(1000000);
		vo.setSale(sale);
		vo.setCoupon(coupon);
		return vo;
	}

}
