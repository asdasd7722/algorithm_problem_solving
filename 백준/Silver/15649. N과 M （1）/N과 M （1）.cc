#include <iostream>
#include <vector>

int N, M;
std::vector<bool> visited(8);
std::vector<int> result;

void dfs(int m) {
	if (M == m) {
		for (auto u : result) {
			std::cout << u << ' ';
		}
		std::cout << '\n';
		return;
	}
	
	for (int i{1}; i <= N; ++i) {
		if (!visited[i]) {
			result.push_back(i);
			visited[i] = true;
			dfs(m + 1);
			result.pop_back();
			visited[i] = false;
		}
	}
}

int main(){
	std::cin >> N >> M;
	dfs(0);
}