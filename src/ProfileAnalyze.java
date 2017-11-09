import java.util.ArrayList;
import java.util.List;

public class ProfileAnalyze {
	
	public List<ProfileTLV> tlvList;

    public ProfileAnalyze() {
        tlvList = new ArrayList<ProfileTLV>();
    }

    public List<ProfileTLV> unpack(byte[] data, int offset){
    	
        int current = offset;//�������ݱ�ǩ
        int lenValue = 0;//L��ֵ

        while(current < data.length){
            ProfileTLV tlvData = new ProfileTLV();

            //��ȡtagֵ����ת��int
            tlvData.setTag(getTagToInt(data,current));
            //2 bytes tag
            current += 2;
            
            lenValue = getLenToInt(data, current);
            tlvData.setLen(lenValue);
            //2 bytes len
            current += 2;
            
            //����valueֵ
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

    //��ȡtag����ת��int
    public int getTagToInt(byte[] data, int offset){
        int mask = 0xFF;
        int temp = 0;
        int result = 0;
        
        for (int i = 0; i < 2; i++) {
            //result <<= 8;//����λ��8
            temp = data[offset + i] & mask;
            result |= temp;//����ȡ����������䵽result�ó��Ҳ��8λ��
        }
        System.out.println("Tag: 0x" + Integer.toHexString(result));
        return result;
    }

    public int getLenToInt(byte[] data, int offset){
        int mask = 0xFF;
        int temp = 0;
        int result = 0;
        
        for (int i = 0; i < 2; i++) {
            //result <<= 8;//����λ��8
            temp = data[offset + i] & mask;
            result |= temp;//����ȡ����������䵽result�ó��Ҳ��8λ��
        }
        System.out.println("Len: 0x" + Integer.toHexString(result));
        return result;
    }
    
    private static char[] HEX_VOCABLE = { '0', '1', '2', '3', '4', '5', '6',
        '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

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

}
