package search;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRCodeGenerate {


//	ByteArrayOutputStream outStream = QRCode.from(code_url).to(ImageType.PNG).withSize(370, 370).stream();
	
//	将数据写入到output/QR_CODE.JPG
	public static void writeQrCode (String message) throws IOException {
	    ByteArrayOutputStream out = QRCode.from(message)  
                .to(ImageType.PNG).withSize(500, 500).stream();  
		 FileOutputStream fout = new FileOutputStream(new File("resource\\output\\QR_CODE.JPG"));  
		fout.write(out.toByteArray());
        fout.flush();  
        fout.close();  
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String code_url = "92ca47d44e5c868d4e45a0baf4ca87f1a1c836277105d6e01642a18dc1b7bb25a92587b336979bc12a62f42787c39d5a253877069227ffa245566f1c99ca3bfbfbaef30306bf59e5244f5acdc0a0d627e264251457b8b0826f71c61dc8ce4edc6c579404577f183a4af1391d044eee3975f417cd0372fa75fd24e3bf56d0666d9938711ba26b11e55fee39e00872d9d0d1b5557a7703f0cafa3b005ff0064f748b9d4712f9a527ea838cb222143af660b12316b1b4460c9da246dac1f85c5226c274c6d85b1f001faadf26b9c272ab35a7ef4ee3d48df305\r\n"
				+ "";
        ByteArrayOutputStream out = QRCode.from(code_url)  
                .to(ImageType.PNG).withSize(500, 500).stream();  
		 FileOutputStream fout = new FileOutputStream(new File("resource\\output\\QR_CODE.JPG"));  

		fout.write(out.toByteArray());
        fout.flush();  
        fout.close();  
//		File file= QRCode.from(code_url).to(ImageType.PNG).withSize(370, 370).file();
	}

}
