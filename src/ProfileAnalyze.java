import java.util.ArrayList;
import java.util.List;

public class ProfileAnalyze {
	
	public List<ProfileTLV> tlvList;

    public ProfileAnalyze() {
        tlvList = new ArrayList<ProfileTLV>();
    }

    public List<ProfileTLV> unpack(byte[] data, int offset){
    	
        int current = offset;//遍历数据标签
        int lenValue = 0;//L的值

        while(current < data.length){
            ProfileTLV tlvData = new ProfileTLV();

            //获取tag值，并转成int
            tlvData.setTag(getTagToInt(data,current));
            //2 bytes tag
            current += 2;
            
            lenValue = getLenToInt(data, current);
            tlvData.setLen(lenValue);
            //2 bytes len
            current += 2;
            
            //设置value值
            byte[] temp = new byte[lenValue];
            System.arraycopy(data, current, temp, 0, lenValue);
            tlvData.setValue(temp);
            current += lenValue;
            System.out.println("V: 0x" + bytesToHex(temp));

            tlvList.add(tlvData);
        }

        return tlvList;
    }

    public static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    //获取tag，并转成int
    public int getTagToInt(byte[] data, int offset){
        int mask = 0xFF;
        int temp = 0;
        int result = 0;
        
        for (int i = 0; i < 2; i++) {
            //result <<= 8;//向左位移8
            temp = data[offset + i] & mask;
            result |= temp;//将获取出的数据填充到result让出右侧的8位上
        }
        System.out.println("Tag: 0x" + Integer.toHexString(result));
        return result;
    }

    public int getLenToInt(byte[] data, int offset){
        int mask = 0xFF;
        int temp = 0;
        int result = 0;
        
        for (int i = 0; i < 2; i++) {
            //result <<= 8;//向左位移8
            temp = data[offset + i] & mask;
            result |= temp;//将获取出的数据填充到result让出右侧的8位上
        }
        System.out.println("Len: 0x" + Integer.toHexString(result));
        return result;
    }
    
    private static char[] HEX_VOCABLE = { '0', '1', '2', '3', '4', '5', '6',
        '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

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

}
