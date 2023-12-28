package common;

import util.ResourceProviderUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Solution1 {
    public static void main(String[] args) {
        InputStream inputStream = ResourceProviderUtil.getResource("common/data.txt");
        ByteArrayOutputStream byteArrayOutputStream = transfer(inputStream);
    }

    public static ByteArrayOutputStream transfer(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            /*4096(размер буфера) - стандартное, оптимальное и используемое в большинстве случаев значение.
             * Можно использовать больше, в зависимости от потребностей приложения*/
            byte[] buff = new byte[4096];

            int byteLength;
            while ((byteLength = inputStream.read(buff)) != -1) {
                byteArrayOutputStream.write(buff, 0, byteLength);
            }

            byteArrayOutputStream.close();
            inputStream.close();

            return byteArrayOutputStream;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}