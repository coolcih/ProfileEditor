import java.util.Locale;

public class ProfileHeader {
	short techMask;
	short profileNumber;
	int profileSize;
	int numTlvs;
	int magicNumber;
	int timeCreated;
	int lastModifiedTime;
	int lastReadTime;
	short version;
	short reserved;
	
	public ProfileHeader() {
		techMask = 1;
		profileNumber = 0;
		profileSize = 32;
		numTlvs = 0;
		magicNumber = 0xa5a5a5a5;
		timeCreated = 0;
		lastModifiedTime = 0;
		lastReadTime = 0;
		version = 0;
		reserved = 0;
	}

	public ProfileHeader(byte[] data) {
		int offset = 0;
		
		techMask = getShort(data, offset);
		offset += 2;
		
		profileNumber = getShort(data, offset);
		offset += 2;
		
		profileSize = getInt(data, offset);
		offset += 4;

		numTlvs = getInt(data, offset);
		offset += 4;

		magicNumber = getInt(data, offset);
		offset += 4;
		
		timeCreated = getInt(data, offset);
		offset += 4;
		
		lastModifiedTime = getInt(data, offset);
		offset += 4;
		
		lastReadTime = getInt(data, offset);
		offset += 4;
		
		version = getShort(data, offset);
		offset += 2;
		
		reserved = getShort(data, offset);
		offset += 2;
		
		System.out.println("techMask:" + techMask);
		System.out.println("profileNumber:" + profileNumber);
		System.out.println("profileSize:" + profileSize);
		System.out.println("numTlvs:" + numTlvs);
		System.out.println("magicNumber:" + Integer.toHexString(magicNumber));
		System.out.println("timeCreated:" + timeCreated);
		System.out.println("lastModifiedTime:" + lastModifiedTime);
		System.out.println("lastReadTime:" + lastReadTime);
		System.out.println("version:" + version);
		System.out.println("reserved:" + reserved);
	}
	
    public int getProfileHeaderLen() {
        return 32;
    }
    
    public int getProfileHeaderTechMask() {
        return this.techMask;
    }
    
    public void putProfileHeaderTechMask(byte[] data, short techMask) {
    	putShort(data, 0, techMask);
    }
    
    public void putProfileHeaderTechMask(byte[] data, String techMask) {
    	byte[] temp = hexStr2Bytes(techMask);
    	if(temp.length < 2) {
    		data[0] = temp[0];
    		data[1] = 0;
    	} else {
    		data[0] = temp[0];
    		data[1] = temp[1];
    	}
    }
    
    public int getProfileHeaderProfileNumber() {
        return this.profileNumber;
    }
    
    public void putProfileHeaderProfileNumber(byte[] data, short profileNumber) {
    	putShort(data, 2, profileNumber);
    }
    
    public int getProfileHeaderProfileSize() {
        return this.profileSize;
    }
    
    public void putProfileHeaderProfileSize(byte[] data, int profileSize) {
    	putInt(data, 4, profileSize);
    }
    
    public int getProfileHeaderNumTlvs() {
        return this.numTlvs;
    }
    
    public void putProfileHeaderNumTlvs(byte[] data, int numTlvs) {
    	putInt(data, 8, numTlvs);
    }
    
    public int getProfileHeaderMagicNumber() {
        return this.magicNumber;
    }
    
    public void putProfileHeaderMagicNumber(byte[] data, int magicNumber) {
    	putInt(data, 12, magicNumber);
    }
    
    public int getProfileHeaderTimerCreated() {
        return this.timeCreated;
    }
    
    public void putProfileHeaderTimeCreated(byte[] data, int timeCreated) {
    	putInt(data, 16, timeCreated);
    }
    
    public int getProfileHeaderLastModifiedTime() {
        return this.lastModifiedTime;
    }
    
    public void putProfileHeaderLastModifiedTime(byte[] data, int lastModifiedTime) {
    	putInt(data, 20, lastModifiedTime);
    }
    
    public int getProfileHeaderLastReadTime() {
        return this.lastReadTime;
    }
    
    public void putProfileHeaderLastReadTime(byte[] data, int lastReadTime) {
    	putInt(data, 20, lastReadTime);
    }
    
    public int getProfileHeaderVersion() {
        return this.version;
    }
    
    public void putProfileHeaderVersion(byte[] data, String version) {
    	byte[] temp = hexStr2Bytes(version);
    	if(temp.length < 2) {
    		data[0] = temp[0];
    		data[1] = 0;
    	} else {
    		data[0] = temp[0];
    		data[1] = temp[1];
    	}
    }
    
    public void putProfileHeaderVersion(byte[] data, short version) {
    	putShort(data, 0, version);
    }
    
    public int getProfileHeaderReservedBytes() {
        return this.reserved;
    }
    
    private short getShort(byte[] b, int index) {
    	return (short) (((b[index + 1] << 8) | b[index + 0] & 0xff));
    }
    
    private void putShort(byte[] b, int index, short value) {
    	b[index] = (byte)(value & 0xff);
    	b[index + 1] = (byte)((value>>8)&0xff);
    }
    
    private int getInt(byte[] bb, int index) {
    	return (int) ((((bb[index + 3] & 0xff) << 24) 
    			     | ((bb[index + 2] & 0xff) << 16) 
    			     | ((bb[index + 1] & 0xff) << 8) 
    			     | ((bb[index + 0] & 0xff) << 0)));
    }
    
    private void putInt(byte[] b, int index, int value) {
    	b[index] = (byte)(value & 0xff);
    	b[index + 1] = (byte)((value>>8)&0xff);
    	b[index + 2] = (byte)((value>>16)&0xff);
    	b[index + 3] = (byte)((value>>24)&0xff);
    }
    
    /**
     * bytes字符串转换为Byte值
     * @param src String Byte字符串，每个Byte之间没有分隔符(字符范围:0-9 A-F)
     * @return byte[]
     */
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
	    		ret[i] = (byte)(Integer.decode("0x"+ src.substring(i*2, m) + src.substring(m,n)) & 0xFF);
	    	 }
    	 }
    	 return ret;
     }
}
