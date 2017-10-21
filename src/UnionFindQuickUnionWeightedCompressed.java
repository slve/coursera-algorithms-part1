import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class UnionFindQuickUnionWeightedCompressed {
	public static final String INDENT = "               ";
	public static final StringBuffer state2str(int[] state) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < state.length; i++)
			str.append(" " + state[i]);
		return str;
	}
	private int[] id;
	private int[] depth;

	public UnionFindQuickUnionWeightedCompressed(int N) {
		StdOut.println(INDENT + "initializing id, N operaton");
		id = new int[N];
		depth = new int[N];
		for (int i = 0; i < N; i++)
		{
			id[i] = i;
			depth[i] = 1;
		}
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UnionFindQuickUnionWeightedCompressed uf = new UnionFindQuickUnionWeightedCompressed(N);
		uf.printState();
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			StdOut.println(INDENT + "$ " + p + " " + q);
			if (!uf.connected(p, q))
			{
				StdOut.println("union " + p + " and " + q);
				uf.union(p, q);
			}
			else
			{
				StdOut.println(INDENT + p + " " + q + " are already connected");
			}
			uf.printState();
		}
	}

	private void printState() {
		StdOut.println(INDENT + "id[]   " + state2str(id));
		StdOut.println(INDENT + "depth[]" + state2str(depth));
	}

	private int root(int i) {
		StringBuffer log = new StringBuffer(INDENT + "root of " + i);
		while (id[i] != i)
		{
			id[i] = id[id[i]];
			i = id[i];
			log = log.append(" > " + i);
		}
		StdOut.println(log);
		return i;
	}

	private void union(int p, int q) {
		int rp = root(p);
		int rq = root(q);
		int dp = depth[rp];
		int dq = depth[rq];
		if (rp == rq) return;

		// in this implementation depth only makes sense for top most nodes
		// because keeping track of the real depth of all nodes is not necessary here
		if (dp < dq)
		{
			StdOut.println(INDENT + "connect " + p + " to " + q + " by pointing " + rp +" to " + rq);
			id[rp] = rq;
			depth[rq] = Math.max(dq, dp + 1);
		}
		else
		{
			StdOut.println(INDENT + "connect " + q + " to " + p + " by pointing " + rq +" to " + rp);
			id[rq] = rp;
			depth[rp] = Math.max(dp, dq + 1);
		}
	}

	private boolean connected(int p, int q) {
		// lazy implementation, we could store or return the roots
		// along with and the following union wouldn't need to lookup the roots again
		return root(p) == root(q);
	}

}
