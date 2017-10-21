import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class UnionFindQuickUnion {
	public static final String INDENT = "               ";
	private int[] id;

	public UnionFindQuickUnion(int N) {
		StdOut.println(INDENT + "initializing id, N operaton");
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UnionFindQuickUnion uf = new UnionFindQuickUnion(N);
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
	
	private int root(int i) {
		StdOut.println(INDENT + "root of " + i + ", first lookup");
		while (id[i] != i)
		{
			i = id[i];
			StdOut.println(INDENT + "root of " + i + ", lookup");
		}
		return i;
	}

	private void union(int p, int q) {
		int rootp = root(p);
		int rootq = root(q);
		id[rootp] = rootq;
	}

	private boolean connected(int p, int q) {
		// lazy implementation, we could store or return the roots
		// along with and the following union wouldn't need to lookup the roots again
		return root(p) == root(q);
	}

}
