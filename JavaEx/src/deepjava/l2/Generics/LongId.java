package deepjava.l2.Generics;

public class LongId<T> {
    private long id;


    public LongId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

//public void manyIdInParams(LongId<User> userId,
//                           LongId<Server> serverId,
//                           LongId<Adress> adress){}
