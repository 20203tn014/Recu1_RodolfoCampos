package mx.edu.utez.server;

    public class User {
        private int id;
        private String name;
        private String lastname;
        private String email;
        private String password;
        private String date_registered;
        private int status;

        public User(){
        }

        public User(int id, String name, String lastname, String email, String password, String date_registered, int status) {
            this.id = id;
            this.name = name;
            this.lastname = lastname;
            this.email = email;
            this.password = password;
            this.date_registered = date_registered;
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDate_registered() {
            return date_registered;
        }

        public void setDate_registered(String date_registered) {
            this.date_registered = date_registered;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }

