Bindu is passionated about clocks.
She found a digital clock, which has 2 rows of led lights,
Top row has 4-leds OOOO indicates hours (0-11).
Bottom row has 6-leds OOOOOO indicates minutes(0-59).
Where O -> led is OFF and * -> led is ON.

For Example: 
If the clock showing the led lights are as follows:
	OO*O indiactes a binary number, 0010 -> 2 hrs
	OO*O** indiactes a binary number, 001011 -> 11 minutes.
So, Time is 2:11

Now, you are given an integer N, number of led lights that are ON.
Your task is to find, all the  possible times in ascending order.

Format of time should be as follows:
	- Hours should not have leading 0's.
	- Minutes should be represented with 2 digits.

Suppose Current time is 1 hous 1 minute
	- Valid time is 1:01
	- Invalid time is as follows:- 01:1, 01:01, 1:1

Input Format:
-------------
An integer N, number of led lights ON.

Output Format:
--------------
Print the list of times in ascending order.


Sample Input:
---------------
1

Sample Output:
----------------
[0:01, 0:02, 0:04, 0:08, 0:16, 0:32, 1:00, 2:00, 4:00, 8:00]


#include <bits/stdc++.h>

using namespace std;

vector<string> find_times(int n) {
    vector<string> times;
    for (int h = 0; h < 12; h++) {
        for (int m = 0; m < 60; m++) {
            if (__builtin_popcount(h) + __builtin_popcount(m) == n) {
                string time = to_string(h) + ":";
                if (m < 10) {
                    time += "0";
                }
                time += to_string(m);
                times.push_back(time);
            }
        }
    }
    return times;
}

int main() {
    int n;
    cin >> n;
    vector<string> times = find_times(n);
    // for (const auto& time : times) {
    //     cout << time << ", ";
    // }
    sort(times.begin(), times.end());
    for (int i = 0; i < times.size(); i++) {
        if(i != times.size()-1)
            cout << times[i] << ", ";
        else
            cout << times[i];
    }
    return 0;
}
