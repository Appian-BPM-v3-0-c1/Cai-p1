# CaConnection con = DatabaseConnection.getCon();
    @Override
    public int save(Store obj) {
        return 0;
    }

    @Override
    public List<Store> findAll(Store store) {
        return (List<Store>) store;
    }

    @Override
    public List<Store> findAll(Store store) {
        return null;
    }

    try {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT * FROM store");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            Store store = new Store();

            try {
                store.setId(rs.getInt("id"));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                store.setCity(rs.getString("name"));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                store.setState(rs.getString("city"));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            try {
                store.setState(rs.getNString("state"));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            storeList.add(store);

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return storeList;

    @Override
    public Store findById(int id) {
        return null;
    }

    @Override
    public List<Store> findAllById(int id) {
        return null;
    }

    @Override
    public boolean update(Store updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
    public List<Store> viewStores() {
        List<Store> storeList = new ArrayList<>();


    }i-p1


public StoreService(StoreDAO storeDAO) {
this.storeDAO = storeDAO;


    }

    public StoreDAO getStoreDAO() {
        return storeDAO;
    }

for(Store s: storeList) {
System.out.println(s);
}