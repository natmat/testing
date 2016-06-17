/*
Using bit shift only. 
sizeof(N) appeared to cause issues.
*/

int solution(int N) {
    // write your code in C99 (gcc 4.8.2)
    if (N == 0) {
        return(0);
    }
    
    int gap = 0;
    int max = 0;
    int start = 0;
    while (N > 0) {
        if (!start) {
            if (0x1 & N) {
                start = 1;
            }
        }
        else {
            if (0x1 & N) {
                if (gap > 0) {
                    max = (max > gap) ? max : gap;
                    gap = 0;
                }
            }
            else {
                gap++;
            }
        }
        N >>= 1;
    }
    return(max);    
}


