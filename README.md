### JPA (standard of ORM. Java.)

Entity manager factory (app = 1ea)
```console
j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
```
Entity manager => DB task (Entity)

persist Entity

if not in caching table, search DB. then load at caching table. 

if insert at db, Latency table(first). ok then flush at DB.



@Entity Mapping
Hibernate: 
    
    create table items (
       item_id bigint not null,
        item_status varchar(255),
        how_many integer not null,
        item_detail longtext not null,
        name varchar(50) not null,
        price integer not null,
        reg_time datetime(6),
        update_time datetime(6),
        primary key (item_id)
    ) engine=InnoDB

