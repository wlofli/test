import java.util.UUID;


public class sqlTextOutPut {
	public static void main(String args[]){
		StringBuffer  buffer = new StringBuffer();
		String str = "INSERT INTO `es_room` VALUES ('";
		String str2 = "', '85";
		String endStr = "', '豪华双床', '1', '5', '10.10.0.76:8080/statics/JD/images/18r1dw.JPG', '00000001168', '00000001168', '00000000000', '00000000000', '0001', '0000', '0000', '0000', '0000', '0', '40', '花园式高级套房，以客家风情与欧陆特色为两种主体风格，静隐于绿色园林之中，这里的一呼一吸都参透着自然清新的气息。', null, null, null);";
		
		for(int i = 1; i <= 20; i++){
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			if(i < 10){
				System.out.println(str + uuid + str2 + '0' + String.valueOf(i)+endStr);
			}else {
				System.out.println(str + uuid + str2 + String.valueOf(i)+endStr);
			}
			
		}
		
	
	}

}
