# COMMANDS TO RUN
`javac *.java`
`java Server <port>`
`java Client 127.0.0.1 <port>`

# NOTE
Server is hosted on the broadcast address of `0.0.0.0` . Configure the `/etc/hosts` to allow connections from all ips and then use the server ip in the client. Else host client on the same machine as the server.

# AVAILABLE OPS
- `add_graph`
- `add_edge`
- `get_mst`

# ALGORITHM FOR MST
### Kruskal's
Used Kruskal's Algorithm for finding the MST. It is implemented using a DSU and has complexity `O(Elog(E))`, where `E` is the number of edges.

# CODE STRUCTURE  

- Server -> implements the server registry and stub creation code.
- RemoteClass -> implements the code for handling remote procedure calls.
- ServerInterface -> specifies remote access interface.
- DSU -> implelments DSU
- Graph -> implements the graph data structure
- Client -> handles the client side operations for specifying RPCs.
