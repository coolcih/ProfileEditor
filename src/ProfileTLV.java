import java.util.Locale;

public class ProfileTLV {
	ProfileType tag;//tag定义成数字是为了方便遍历使用
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
    
    //bytes数组转换成string
    public static String bytesToHex(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            //获取高4位的数据值，正好对应HEX_VOCABLE数组中的下标，和相应char的值
            int high = (b >> 4) & 0x0f;
            //获取低4位的数据值，正好对应HEX_VOCABLE数组中的下标，和相应char的值
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
   	 /*对输入值进行规范化整理*/
   	 src = src.trim().replace(" ", "").toUpperCase(Locale.US);
   	 src = src.trim().replace("0X", "");
   	 byte[] ret;
   	 
   	 System.out.println("src: " + src);
   	 
   	 if(src.length() < 2) {
   		 ret = new byte[1];
   		 ret[0] = (byte)(Integer.decode("0x" + src) & 0xFF);
   	 } else {
   		 //处理值初始化
	    	 int m=0,n=0;
	    	 int iLen=src.length()/2; //计算长度
	    	 ret = new byte[iLen]; //分配存储空间
	
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

