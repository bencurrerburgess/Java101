class Place {
    private String name, description;
    Place[] exits;

    Place(String name, String description) {
        this.name = name;
        this.description = description;
    }

    void arrive() {
        System.out.println(description);
    }
}
