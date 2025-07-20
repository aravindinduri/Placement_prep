# 📘 Graph Algorithms Cheatsheet

---

## 📌 1. Depth-First Search (DFS)

**Use Case:** Explore all nodes deeply before backtracking. Great for cycle detection, component counting, etc.

```java
class Solution {
    public void solve(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int v : adj.get(node)) {
            if (!visited[v]) {
                solve(adj, v, visited);
            }
        }
    }

    public static void main(String args[]) {
        int n = 5; // Example size
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) adj.add(new ArrayList<>()); // initialize adjacency list

        // Add edges here

        Solution sol = new Solution();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                sol.solve(adj, i, visited);
            }
        }
    }
}
```

> 🔍 **Trick:** Use DFS for problems involving recursion, cycle detection, backtracking, and connected components.

---

## 📌 2. Breadth-First Search (BFS)

**Use Case:** Level-wise traversal, shortest path when all edge weights = 1.

```java
class Solution {
    public static void main(String args[]) {
        int n = 5; // Example size
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Add edges here

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (int neighbour : adj.get(v)) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}
```

> 💡 **Trick:** BFS is ideal when looking for the shortest path in **unweighted** graphs.

---

## 📌 3. Topological Sort (DFS-based)

**Use Case:** Linear ordering of vertices in a DAG (Directed Acyclic Graph).

```java
class Solution {
    public void topoSort(int node, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (int v : adj.get(node)) {
            if (!visited[v]) {
                topoSort(v, visited, stack, adj);
            }
        }
        stack.push(node);
    }

    public static void main(String args[]) {
        int n = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Add edges for DAG

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        Solution sol = new Solution();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                sol.topoSort(i, visited, stack, adj);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
```

> 🎯 **Trick:** Use when dependencies/order of execution is required. (e.g., course scheduling).

---

## 📌 4. Disjoint Set Union (DSU / Union-Find)

```java
class DSU {
    int[] parent, rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (x != parent[x])
            parent[x] = find(parent[x]); // Path compression
        return parent[x];
    }

    void union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) return;
        if (rank[xr] < rank[yr]) parent[xr] = yr;
        else if (rank[xr] > rank[yr]) parent[yr] = xr;
        else {
            parent[yr] = xr;
            rank[xr]++;
        }
    }
}
```

> 🔐 **Trick:** Perfect for cycle detection, Kruskal's MST, or connected components.

---

## 📌 5. Dijkstra's Algorithm

**Use Case:** Shortest path from a source when weights are non-negative.

```java
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        int[][] res = new int[m][n];
        for (int[] row : res) Arrays.fill(row, Integer.MAX_VALUE);
        res[0][0] = 0;
        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int x = temp[0], y = temp[1], effort = temp[2];

            if (x == m - 1 && y == n - 1) return effort;

            for (int[] d : dir) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    int newEff = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (newEff < res[nx][ny]) {
                        res[nx][ny] = newEff;
                        pq.add(new int[]{nx, ny, newEff});
                    }
                }
            }
        }
        return 0;
    }
}
```

> 📏 **Trick:** Use when shortest path with **positive weights** is required.

---

## 📌 6. Bellman-Ford Algorithm

**Use Case:** Detect negative weights and cycles.

```java
class Solution {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int[] e : edges) {
                int u = e[0], v = e[1], wt = e[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                    dist[v] = dist[u] + wt;
            }
        }

        // Negative cycle detection
        for (int[] e : edges) {
            int u = e[0], v = e[1], wt = e[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v])
                return new int[]{-1};
        }

        return dist;
    }
}
```

> ⚠️ **Trick:** Only algo to detect **negative cycles**. Use if graph contains negative weights.

---

## 📌 7. Floyd-Warshall Algorithm

**Use Case:** All-pairs shortest path.

```java
class Solution {
    public void shortestDistance(int[][] mat) {
        int n = mat.length;

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][via] != Integer.MAX_VALUE && mat[via][j] != Integer.MAX_VALUE)
                        mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }
    }
}
```

> 🧠 **Trick:** Works well for dense graphs with **all-pairs shortest paths**.

---

## 📌 8. Prim's Algorithm (MST - Minimum Spanning Tree)

```java
class Solution {
    static int spanningTree(int V, List<List<int[]>> adj) {
        int res = 0;
        boolean[] visited = new boolean[V];
        int[] key = new int[V];
        int[] parent = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        key[0] = 0;
        pq.add(new int[]{0, 0}); // weight, node

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int wt = curr[0], u = curr[1];
            if (visited[u]) continue;

            visited[u] = true;
            res += wt;

            for (int[] edge : adj.get(u)) {
                int v = edge[0], weight = edge[1];
                if (!visited[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new int[]{weight, v});
                    parent[v] = u;
                }
            }
        }

        System.out.println("MST Edges:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i);
        }

        return res;
    }
}
```

> 🌿 **Trick:** Greedy MST algo using min heap. Good for dense graphs.

---

## 📌 9. Kruskal's Algorithm (MST using DSU)

```java
class Solution {
    static int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }

    static void union(int x, int y, int[] parent, int[] rank) {
        int xr = find(x, parent), yr = find(y, parent);
        if (xr == yr) return;

        if (rank[xr] < rank[yr]) parent[xr] = yr;
        else if (rank[xr] > rank[yr]) parent[yr] = xr;
        else {
            parent[yr] = xr;
            rank[xr]++;
        }
    }

    static int spanningTree(int V, List<List<int[]>> adj) {
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        List<int[]> edges = new ArrayList<>();
        for (int u = 0; u < V; u++) {
            for (int[] edge : adj.get(u)) {
                int v = edge[0], wt = edge[1];
                edges.add(new int[]{u, v, wt});
            }
        }

        edges.sort(Comparator.comparingInt(e -> e[2]));
        int res = 0;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            if (find(u, parent) != find(v, parent)) {
                res += wt;
                union(u, v, parent, rank);
            }
        }

        return res;
    }
}
```

> 🔧 **Trick:** Works best when edge list is given. Efficient for sparse graphs.

---

## ✅ Summary Table

| Algorithm        | Use Case                        | Handles Negative Weights? | Best For                             |
|------------------|----------------------------------|----------------------------|--------------------------------------|
| DFS              | Deep traversal, components       | ❌                         | Cycles, paths, connected comp        |
| BFS              | Shortest path unweighted         | ❌                         | Level-order, shortest path           |
| Topological Sort | DAG Ordering                     | ❌                         | Task scheduling                      |
| Dijkstra         | Shortest path (non-negative)     | ❌                         | Path cost, routing                   |
| Bellman-Ford     | Shortest path (can be negative)  | ✅                         | Negative weights, cycle detection    |
| Floyd-Warshall   | All-pairs shortest path          | ✅                         | Dense graphs                         |
| Prim's MST       | Min spanning tree                | ❌                         | Dense graphs                         |
| Kruskal's MST    | Min spanning tree                | ❌                         | Sparse graphs                        |
| DSU              | Union-Find, MST (Kruskal)        | N/A                        | Connected components, cycles         |

---

Happy Coding! 💻✨
