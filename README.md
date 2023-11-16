### JPA (standard of ORM. Java.)

Entity manager factory (app = 1ea)

Entity manager => DB task (Entity)

persist Entity

if not in caching table, search DB. then load at caching table. 

if insert at db, Latency table(first). ok then flush at DB.
