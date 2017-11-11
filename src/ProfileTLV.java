import java.util.Locale;

public class ProfileTLV {
	ProfileType tag;//tag�����������Ϊ�˷������ʹ��
    int len;
    byte[] value;
    private static char[] HEX_VOCABLE = { '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    
    public ProfileTLV() {
    	this.tag = ProfileType.INVALID_PROFILE_PARAM;
    	this.len = 0;
    	this.value = null;
    }
    public ProfileTLV(int tagvalue, byte[] value) {
    	for( ProfileType type : ProfileType.values()){
    		if(type.getTypeKey() == tagvalue)
    			this.tag = type;
    	}
    	this.len = value.length;
    }
    
    public ProfileTLV(int tagvalue, String value) {
    	for( ProfileType type : ProfileType.values()){
    		if(type.getTypeKey() == tagvalue)
    			this.tag = type;
    	}
    	setValue(value);
    }
    
    public int getTag() {
        return tag.getTypeKey();
    }
    
    public void setTag(int tag) {
    	this.tag = ProfileType.INVALID_PROFILE_PARAM;
    	for( ProfileType type : ProfileType.values()){
    		if(type.getTypeKey() == tag)
    			this.tag = type;
    	}
    	if(this.tag == ProfileType.INVALID_PROFILE_PARAM)
    		System.out.println("Invalid input tag value");
    }
    
    public int getLen() {
        return len;
    }
    
    public void setLen(int len) {
        this.len = len;
    }
    
    public byte[] getValue() {
        return value;
    }

    public String getValueString() {
        return bytesToHex(value);
    }
    
    //bytes����ת����string
    public static String bytesToHex(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            //��ȡ��4λ������ֵ�����ö�ӦHEX_VOCABLE�����е��±꣬����Ӧchar��ֵ
            int high = (b >> 4) & 0x0f;
            //��ȡ��4λ������ֵ�����ö�ӦHEX_VOCABLE�����е��±꣬����Ӧchar��ֵ
            int low = b & 0x0f;
            sb.append(HEX_VOCABLE[high]);
            sb.append(HEX_VOCABLE[low]);
        }
        return sb.toString();
    }
    
    public void setValue(byte[] value) {
        this.value = value;
    }
    
    public void setValue(String value) {
    	byte[] temp = hexStr2Bytes(value);

    	for(int i = 0; i<temp.length; i++) {
    		this.value = temp;
    	}
    	
    	this.len = temp.length;
    }
    
    private byte[] hexStr2Bytes(String src){
   	 /*������ֵ���й淶������*/
   	 src = src.trim().replace(" ", "").toUpperCase(Locale.US);
   	 src = src.trim().replace("0X", "");
   	 byte[] ret;
   	 
   	 System.out.println("src: " + src);
   	 
   	 if(src.length() < 2) {
   		 ret = new byte[1];
   		 ret[0] = (byte)(Integer.decode("0x" + src) & 0xFF);
   	 } else {
   		 //����ֵ��ʼ��
	    	 int m=0,n=0;
	    	 int iLen=src.length()/2; //���㳤��
	    	 ret = new byte[iLen]; //����洢�ռ�
	
	    	 for(int i = 0; i < iLen; i++){
	    		m=i*2+1;
	    		n=m+1;
	    		System.out.println("convert: " + src.substring(i*2, m) + src.substring(m,n));
	    		ret[i] = (byte)(Integer.decode("0x"+ src.substring(i*2, m) + src.substring(m,n)) & 0xFF);
	    		System.out.println("after convert: " + ret[i]);
	    	}
   	 }
   	 return ret;
    }
}

