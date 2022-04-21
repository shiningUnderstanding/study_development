package line;

public class cell {
	public static void main(String[] args) {
		int answer = 0;
		int[] arr = {3, 7, 2, 4};
		int[] brr = {4, 5, 5, 2};

		System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2] + ", " + arr[3]);
		System.out.println(brr[0] + ", " + brr[1] + ", " + brr[2] + ", " + brr[3]);
        //0번끼리 비교 후 0번 1번 바꾸기
        int dif1 = arr[0] - brr[0];
        if(dif1 > 0){
            arr[0] = arr[0] - dif1;
            arr[1] = arr[1] + dif1;
            System.out.println(0);
            answer++;
        }else if(dif1 < 0){
            arr[0] = arr[0] - dif1;
            arr[1] = arr[1] + dif1;
            System.out.println(0);
            answer++;
        }
        
        System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2] + ", " + arr[3]);

        //1번끼리 비교 후 1번 2번 바꾸기        
        int dif2 = arr[1] - brr[1];
        if(dif2 > 0){
            arr[1] = arr[1] - dif2;
            arr[2] = arr[2] + dif2;
            System.out.println(1);
            answer++;
        }else if(dif2 < 0){
            arr[1] = arr[1] - dif2;
            arr[2] = arr[2] + dif2;
            System.out.println(1);
            answer++;
        }

        //2번끼리 비교 후 2번 3번 바꾸기        
        int dif3 = arr[2] - brr[2];
        System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2] + ", " + arr[3]);
        if(dif3 > 0){
            arr[2] = arr[2] - dif3;
            arr[3] = arr[3] + dif3;
            System.out.println(2);
            answer++;
        }else if(dif3 < 0){
            arr[2] = arr[2] - dif3;
            arr[3] = arr[3] + dif3;
            System.out.println(2);
            answer++;
        }
        
        System.out.println(arr[0] + ", " + arr[1] + ", " + arr[2] + ", " + arr[3]);
        
        System.out.println(answer);
	}
}
