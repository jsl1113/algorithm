#include <iostream>
#include <vector>
using namespace std;

bool p(int n) {
    // n�� 3 �̻��̴�.
    int tmp = 3;
    while (n > tmp) {
        if (n % tmp == 0) {
            return false;
        }
        tmp++;
    }
    return true;
}

int main() {

}