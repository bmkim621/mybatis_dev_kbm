package kr.or.yi.mybatis_dev_kbm;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.mybatis_dev_kbm.dao.UserPicMapper;
import kr.or.yi.mybatis_dev_kbm.dao.UserPicMapperImpl;
import kr.or.yi.mybatis_dev_kbm.dto.UserPic;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPicMapperTest extends AbstractTest {
	private UserPicMapper dao = new UserPicMapperImpl();

	@Test
    public void testAInsertUserPic() throws IOException{
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        UserPic userPic = new UserPic();
        userPic.setName("pororo");
        userPic.setBio("put some lengthy bio here");
        userPic.setPic(getPicFile());
        int result = dao.insertUserPic(userPic);
        Assert.assertSame(1, result);
    }

	@Test
    public void testBGetUserPic() throws IOException {
        UserPic userPic = dao.getUserPic(1);
        if (userPic.getPic() != null) {
            File file = getPicFile(userPic);
            System.out.println("file path " + file.getAbsolutePath());
        }
        Assert.assertNotNull(userPic);
    }
    
    private File getPicFile(UserPic userPic) throws IOException {
        File pics = new File(System.getProperty("user.dir") + "\\pics\\");
        if (!pics.exists()) {
            pics.mkdir();
        }
        File file = new File(pics, userPic.getName() + ".png");
        try (FileOutputStream output = new FileOutputStream(file)) {
            output.write(userPic.getPic());
        }
        return file;
    }

    
    private byte[] getPicFile() throws IOException {
        byte[] pic = null;
        File file = new File(System.getProperty("user.dir") + "\\images\\1.png");
        try (InputStream is = new FileInputStream(file);){
            pic = new byte[is.available()];
            is.read(pic);
        } 
        return pic;
    }

}
