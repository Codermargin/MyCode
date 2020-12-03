package com.xyx.DailyLeetCode;

public class countPrimes_204 {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(countPrimes(n));
    }

    /**
     * 计算质数
     * 计算小于n的质数有几个
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
        /*【埃氏筛】
        public int countPrimes(int n) {
            int[] isPrime = new int[n];
            Arrays.fill(isPrime, 1);
            int ans = 0;
            for (int i = 2; i < n; ++i) {
                if (isPrime[i] == 1) {
                    ans += 1;
                    if ((long) i * i < n) {
                        for (int j = i * i; j < n; j += i) {
                            isPrime[j] = 0;
                        }
                    }
                }
            }
            return ans;
        }
        */
        /*
        * public int countPrimes(int n) {
            List<Integer> primes = new ArrayList<Integer>();
            int[] isPrime = new int[n];
            Arrays.fill(isPrime, 1);
            for (int i = 2; i < n; ++i) {
                if (isPrime[i] == 1) {
                    primes.add(i);
                }
                for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                    isPrime[i * primes.get(j)] = 0;
                    if (i % primes.get(j) == 0) {
                        break;
                    }
                }
            }
            return primes.size();
        }
        */
    }

    public static boolean isPrime(int i) {
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0){
                return false;
            }
        }
        return true;
    }
}
