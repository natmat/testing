/*
First attempt.
start - set true when first bit==1 encountered
gap - incremented on each bit==zero
max - records max gap
when started, if bit==1 then update max and clear gap

fails: doesn't find enough bits in the input int.
*/

#define BIT(N,i) (0x1 & ((N)>>(i)))

int solution(int N) {
    // write your code in C99 (gcc 4.8.2)
    if (N == 0) {
        return(0);
    }
    
    int l = 4*sizeof(N);
    int i;
    int gap = 0;
    int max = 0;
    int start = 0;
    for (i = 0 ; i < l ; i++) {
        if (!start) {
            if (BIT(N,i)) {
                start = 1;
            }
            continue;
        }
        else {
            if (BIT(N,i)) {
                if (gap > 0) {
                    max = (max > gap) ? max : gap;
                    gap = 0;
                }
                else {
                    continue;
                }
            }
            else {
                gap++;
            }
        }
    }
    return(max);    
}

