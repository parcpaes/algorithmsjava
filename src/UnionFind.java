
public class UnionFind {
    private int size;
    private int sz[];
    private int rank[];
    private int id[];
    private int numComponentes;
    public UnionFind(int size){
        if(size<=0) throw new IllegalArgumentException("Size <= 0 is not allowed");
        this.size = numComponentes = size;
        sz = new int [size];
        id = new int[size];
        rank = new int[size];
        for(int i=0; i<size; i++){
            id[i]=i;// link to itself(self root)
            sz[i]=1;
            rank[i]=0;
        }
    }

    public int find(int p){
        if(p!= id[p]) id[p] = find(id[p]);
        return id[p];
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    public int size(){
        return size;
    }
    public int components(){
        return numComponentes;
    }

    public void unifyWeight(int p, int q){
        //p= child(root1) and q parent(root2) sz[]>sz[]
        //p= parent(root1) and q child(root2) sz[]<sz[]
        int root1 = find(p);
        int root2 = find(q);
        if(root1 == root2) return;
        if(sz[root1] > sz[root2]){
            id[root2]=root1;
            sz[root1]+=sz[root2];

        }else{
            id[root1] = root2;
            sz[root2]+=sz[root1];
        }
        numComponentes--;
    }
}
