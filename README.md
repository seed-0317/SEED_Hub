# project2-a

### Contributors
* Amanda
* Chris
* Cory
* Sudhakar
* Steve Morris
* Steve Mustanski

# Development Environment

### Environment Variables (for postgres)
* `URL`
* `USERNAME`
* `PASSWORD`

### drop tables

```sql
drop table employee;
drop table department;
```

### create tables and insert data

```sql
create table department(
  d_id serial primary key,
  d_name text
);

create table employee(
  e_id serial primary key,
  e_name text unique,
  d_id int,
  foreign key (d_id) references department(d_id)
);

INSERT INTO department(d_name) VALUES('sales');
INSERT INTO department(d_name) VALUES('finance');
INSERT INTO department(d_name) VALUES('marketing');

INSERT INTO employee(e_name, d_id) VALUES('john',     1);
INSERT INTO employee(e_name, d_id) VALUES('amy',      1);
INSERT INTO employee(e_name, d_id) VALUES('austin',   2);
INSERT INTO employee(e_name, d_id) VALUES('katie',    2);
INSERT INTO employee(e_name, d_id) VALUES('courtney', 2);
INSERT INTO employee(e_name)      VALUES('scout');

```

