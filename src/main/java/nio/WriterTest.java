package nio;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class WriterTest {

	static int writeCount = 1;
	static String inputStr = "very woman is a" + " treasure but way too often we forget"
			+ " how precious they are. We get lost in daily "
			+ "chores and stinky diapers, in work deadlines and dirty dishes, in daily errands and occasional breakdowns.";

	public static void main(String[] args) throws Exception {
		Options opt = new OptionsBuilder().include(WriterTest.class.getSimpleName()).forks(1).build();
		new Runner(opt).run();

	}

//	@Benchmark
//	@BenchmarkMode(Mode.SingleShotTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	public void TestFileWriter() throws IOException {
//		File file = new File("/Users/xujianxing/Desktop/fileWithWriter.txt");
//		FileWriter fileWriter = new FileWriter(file);
//		for (int i = 0; i < writeCount; i++) {
//			fileWriter.write("JAVA TEST");
//		}
//
//	}
//
//	@Benchmark
//	@BenchmarkMode(Mode.SingleShotTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	public void TestBuffer() throws IOException {
//		File file = new File("/Users/xujianxing/Desktop/buffer.txt");
//		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(file));
//		for (int i = 0; i < writeCount; i++) {
//			buffer.write(inputStr.getBytes());
//		}
//		buffer.flush();
//		buffer.close();
//	}
//
//	@Benchmark
//	@BenchmarkMode(Mode.SingleShotTime)
//	@OutputTimeUnit(TimeUnit.MILLISECONDS)
//	public void TestNormal() throws IOException {
//		File file = new File("/Users/xujianxing/Desktop/normal.txt");
//		FileOutputStream out = new FileOutputStream(file);
//		for (int i = 0; i < writeCount; i++) {
//			out.write(inputStr.getBytes());
//
//		}
//		out.close();
//
//	}

	@Benchmark
	@BenchmarkMode(Mode.SingleShotTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void TestNIO() throws IOException {
		TimeMonitor.start();
		File file = new File("/Users/xujianxing/Desktop/nio.txt");
		NIOWriter nioWriter = new NIOWriter(file, 2048);
//		TimeMonitor.end("NIOWriter nioWriter = new NIOWriter(file, 2048);");
		for (int i = 0; i < writeCount; i++) {
//			TimeMonitor.start();
			nioWriter.write(inputStr);
//			TimeMonitor.end("nioWriter.write(inputStr)");
		}
//		TimeMonitor.start();
		nioWriter.close();
		TimeMonitor.end("	nioWriter.close()");
	}

}
