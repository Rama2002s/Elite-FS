You are given a set of releases of a software and you are asked to find the most
recent release. There may be multiple checkins of the software in a given branch. 

Each branch may also have sub branches. For example release 3-5-4 refers to the 
fourth checkin in the fifth sub branch of the third main branch. 
This hierarchy can go upto any number of levels. 

If a level is missing it is considered as level 0 in that hierarchy. 
For example 3-5-7 is  same as 3-5-7-0 or even same as 3-5-7-0-0. 
The higher numbers denote more recent releases. 

For example 3-5-7-1 is more recent than 3-5-7 but less recent than 3-6.

Input Format:
-------------
A single line space separated strings, list of releases 

Output Format:
--------------
Print the latest release of the software.


Sample Input-1:
---------------
1-2 1-2-3-0-0 1-2-3

Sample Output-1:
----------------
1-2-3

Sample Input-2:
---------------
3-5-4 3-5-7 3-5-7-1 3-5-7-0-0 3-6

Sample Output-2:
----------------
3-6



#include <bits/stdc++.h>
using namespace std;

string addHyphens(const string& str) {
    string result;
    for (size_t i = 0; i < str.length(); i++) {
        result += str[i];
        if (i != str.length() - 1) {
            result += "-";
        }
    }
    return result;
}

bool compareStrings(const string& str1, const string& str2) {
    size_t i = 0;
    while (i < str1.length() && i < str2.length()) {
        if (str1[i] != str2[i]) {
            return str1[i] > str2[i];
        }
        i++;
    }
    return str1.length() > str2.length();
}

void customSort(vector<string>& strings) {
    sort(strings.begin(), strings.end(), compareStrings);
}

void removeHyphensAndZeros(vector<string>& releaseList) {
    for (string& number : releaseList) {
        number.erase(remove(number.begin(), number.end(), '-'), number.end());

        // Remove leading zeros
        number.erase(0, number.find_first_not_of('0'));

        // Remove trailing zeros
        size_t trailingZeros = number.find_last_not_of('0') + 1;
        if (trailingZeros < number.length()) {
            number.erase(trailingZeros);
        }

        if (number.empty()) {
            number = "0";
        }
    }
}



int main() {
    string releases;
    getline(cin, releases);

    stringstream ss(releases);
    string release;
    vector<string> releaseList;

    while (getline(ss, release, ' ')) {
        releaseList.push_back(release);
    }
    
    removeHyphensAndZeros(releaseList);
    customSort(releaseList);
    
    cout << addHyphens(releaseList[0]);

    return 0;
}
