import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class UnionFindQuick {
	public static final String INDENT = "               ";
	private int[] id;

	public UnionFindQuick(int N) {
		StdOut.println(INDENT + "initializing id, N operaton");
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UnionFindQuick uf = new UnionFindQuick(N);
		uf.printId();
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			StdOut.println(INDENT + "> " + p + " " + q);
			if (!uf.connected(p, q))
			{
				uf.union(p, q);
				StdOut.println("connect " + p + " " + q);
			}
			else
			{
				StdOut.println(INDENT + p + " " + q + " are already connected");
			}
			uf.printId();
		}
	}

	private void printId() {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < id.length; i++)
			str.append(" " + id[i]);
		StdOut.println(INDENT + str);
	}

	private void union(int p, int q) {
		int idp = id[p];
		int idq = id[q];
		StdOut.println(INDENT + "union, lookup N times");
		for (int i = 0; i < id.length; i++)
			if (id[i] == idp)
				id[i] = idq;
	}

	private boolean connected(int p, int q) {
		return id[p] == id[q];
	}

}
