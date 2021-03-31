package interfaces;

import java.io.File;
import java.io.IOException;

public interface IBuilder {
	public void compile (File file) throws IOException, InterruptedException;
}
