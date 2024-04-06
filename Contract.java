public interface Contract {
    public void grab(String item);
    public String drop(String item);
    public void examine(String item);
    public void use(String item);
    public boolean walk(String direction);
    public boolean fly(int x, int y, int z);
    public Number shrink();
    public Number grow();
    public void rest();
    public void undo();
}