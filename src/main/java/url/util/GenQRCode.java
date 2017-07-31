package url.util;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import url.model.Mapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static url.util.Constant.HOST;

/**
 * Created by AnLu on
 * 2017/7/28 20:57.
 * url_short
 */
public class GenQRCode {
    public static void gen(Mapper mapper,String path) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(path + mapper.getCreation() + ".png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        QRCode.from(HOST.concat(mapper.getOriginal()))
                .withSize(500, 500)
                .withColor(0xFFFF0000, 0xFFFFFFAA)
                .to(ImageType.PNG)
                .writeTo(outputStream);
    }
}
