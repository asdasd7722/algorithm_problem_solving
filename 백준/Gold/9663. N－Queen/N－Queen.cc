#include <iostream>
#include <vector>

int n, result{};
std::vector<int> queen_loc(15);

bool check(int level) {
	for (int i{}; i < level; ++i) {
		if (queen_loc[i] == queen_loc[level] || 
			abs(queen_loc[level] - queen_loc[i]) == level - i) {
			return false;
		}
	}
	return true;
}

void solve(int row) {
	if (row == n) {
		++result;
		return;
	}

	for (int i{}; i < n; ++i) {
		queen_loc[row] = i;
		if (check(row)) solve(row + 1);
	}
}

int main() {
	std::cin >> n;
	solve(0);
	std::cout << result;
}