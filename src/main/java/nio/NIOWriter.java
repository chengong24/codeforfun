package nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOWriter {

	private FileChannel fileChannel;
	private ByteBuffer buf;

	@SuppressWarnings("resource")
	public NIOWriter(File file, int capacity) {
		try {
			
			fileChannel = new FileOutputStream(file).getChannel();
			
			buf = ByteBuffer.allocate(capacity);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 不采用递归是因为如果字符串过大而缓存区过小引发StackOverflowException
	 * 
	 * @param str
	 * @throws IOException
	 */
	public void write(String str) throws IOException {
		
		int length = str.length();
		byte[] bytes = str.getBytes();
		int startPosition = 0;
		do {
			startPosition = write0(bytes, startPosition);
		} while (startPosition < length);
	
	}

	public int write0(byte[] bytes, int position) throws IOException {
	
		if (position >= bytes.length) {
			return position;
		}
		while (buf.hasRemaining()) {
			if (position < bytes.length) {
				buf.put(bytes[position]);
				position++;
			} else {
				break;
			}
		}
		buf.flip();
	
	
		fileChannel.write(buf);
		
		buf.clear();
		return position;
	}

	/**
	 * 强制写入数据。并且关闭连接
	 */
	public void close() {
		try {
			fileChannel.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		File file = new File("/Users/xujianxing/Desktop/ab.txt");
		String inputStr = "very woman is a" + " treasure but way too often we forget"
				+ " how precious they are. We get lost in daily "
				+ "chores and stinky diapers, in work deadlines and dirty dishes, in daily errands and occasional breakdowns.";
		NIOWriter wp = new NIOWriter(file, 2048);
		wp.write(inputStr);
		wp.close();
	}
}
