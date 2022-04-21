package dfsbfs;

public class Distance {
	static boolean[] visit;
	static int[] sequence;
    static int[][] copy_dist;

    public static void main(String[] args) {
    	int[][] dist = {{0,5,2,4,1}, {5,0,3,9,6}, {2,3,0,6,3}, {4,9,6,0,3}, {1,6,3,3,0}};
        int N = dist.length;
        copy_dist = dist;
		visit = new boolean[N];
		sequence = new int[N];
        permutation(N, 0);
        int[][] answer = {};
    }

    static void permutation(int N, int depth) {
		if(depth == N) {
            check(sequence);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				sequence[depth] = i + 1;
				permutation(N, depth + 1);
				visit[i] = false;
			}
		}
	}

    //i번째에서 (i + 2번 까지의 거리) - (i + 1 번 까지의 거리) = (i + 1 에서) ~ (i + 2)까지 거리
    static void check(int[] sequence){
        for(int i = 0; i < sequence.length - 2; i++){
            if(!((copy_dist[sequence[i] - 1][sequence[i + 2] - 1] - copy_dist[sequence[i] - 1][sequence[i + 1] - 1]) == copy_dist[sequence[i + 1] - 1][sequence[i + 2] - 1])){
                System.out.println("yes");
            }
        }
    }
}
