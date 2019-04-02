
CREATE TABLE public.usuario(
	id_usuario serial NOT NULL,
	nombre_uno varchar(25) NOT NULL,
	nombre_dos varchar(25),
	apellido_uno varchar(25) NOT NULL,
	apellido_dos varchar(25),
	id_rol serial NOT NULL,
	nombre_usuario varchar(40) NOT NULL,
	contrasenia varchar(30) NOT NULL,
	CONSTRAINT conductor_pk PRIMARY KEY (id_usuario)

);
-- ddl-end --
ALTER TABLE public.usuario OWNER TO tpi2019;

CREATE TABLE public.medio_contacto(
	id_medio_contacto serial NOT NULL,
	id_usuario serial NOT NULL,
	CONSTRAINT medio_contacto_pk PRIMARY KEY (id_medio_contacto)

);
-- ddl-end --
ALTER TABLE public.medio_contacto OWNER TO tpi2019;

CREATE TABLE public.tipo_medio_contacto(
	id_tipo_medio_contacto serial NOT NULL,
	id_medio_contacto serial NOT NULL,
	telefono varchar(9) NOT NULL,
	correo varchar(100),
	facebook varchar(100),
	instagram varchar(100),
	CONSTRAINT tipo_medio_contacto_pk PRIMARY KEY (id_tipo_medio_contacto)

);
-- ddl-end --
ALTER TABLE public.tipo_medio_contacto OWNER TO tpi2019;
-- ddl-end --

-- object: public.vehiculo | type: TABLE --
-- DROP TABLE IF EXISTS public.vehiculo CASCADE;
CREATE TABLE public.vehiculo(
	id_vehiculo serial NOT NULL,
	id_usuario serial NOT NULL,
	CONSTRAINT vehiculo_pk PRIMARY KEY (id_vehiculo)

);
-- ddl-end --
ALTER TABLE public.vehiculo OWNER TO tpi2019;
-- ddl-end --

-- object: public.marca | type: TABLE --
-- DROP TABLE IF EXISTS public.marca CASCADE;
CREATE TABLE public.marca(
	id_marca serial NOT NULL,
	id_vehiculo serial NOT NULL,
	marca varchar(50) NOT NULL,
	CONSTRAINT marca_pk PRIMARY KEY (id_marca)

);
-- ddl-end --
ALTER TABLE public.marca OWNER TO tpi2019;
-- ddl-end --

-- object: public.modelo | type: TABLE --
-- DROP TABLE IF EXISTS public.modelo CASCADE;
CREATE TABLE public.modelo(
	id_modelo serial NOT NULL,
	id_marca serial NOT NULL,
	modelo varchar(50) NOT NULL,
	CONSTRAINT modelo_pk PRIMARY KEY (id_modelo)

);
-- ddl-end --
ALTER TABLE public.modelo OWNER TO tpi2019;
-- ddl-end --

-- object: public.caractetistica | type: TABLE --
-- DROP TABLE IF EXISTS public.caractetistica CASCADE;
CREATE TABLE public.caractetistica(
	id_caracteristica serial NOT NULL,
	id_modelo serial NOT NULL,
	CONSTRAINT caractetistica_pk PRIMARY KEY (id_caracteristica)

);
-- ddl-end --
ALTER TABLE public.caractetistica OWNER TO tpi2019;
-- ddl-end --

-- object: public.tipo_caracteristica | type: TABLE --
-- DROP TABLE IF EXISTS public.tipo_caracteristica CASCADE;
CREATE TABLE public.tipo_caracteristica(
	id_tipo_caracteristica serial NOT NULL,
	id_caracteristica serial NOT NULL,
	color varchar(15) NOT NULL,
	anio date NOT NULL,
	capacidad integer NOT NULL,
	otras_caracteristicas varchar(100),
	CONSTRAINT tipo_caracteristica_pk PRIMARY KEY (id_tipo_caracteristica)

);
-- ddl-end --
ALTER TABLE public.tipo_caracteristica OWNER TO tpi2019;
-- ddl-end --

-- object: public.trayectoria | type: TABLE --
-- DROP TABLE IF EXISTS public.trayectoria CASCADE;
CREATE TABLE public.trayectoria(
	id_trayectoria serial NOT NULL,
	id_usuario serial NOT NULL,
	padre integer,
	referencia varchar(50),
	tarifa float NOT NULL,
	hora_salida time NOT NULL,
	hora_llegada time NOT NULL,
	CONSTRAINT trayectoria_pk PRIMARY KEY (id_trayectoria)

);
-- ddl-end --
ALTER TABLE public.trayectoria OWNER TO tpi2019;
-- ddl-end --

-- object: public.rol | type: TABLE --
-- DROP TABLE IF EXISTS public.rol CASCADE;
CREATE TABLE public.rol(
	id_rol serial NOT NULL,
	nombre_rol varchar(25),
	CONSTRAINT rol_pk PRIMARY KEY (id_rol)

);
-- ddl-end --
ALTER TABLE public.rol OWNER TO tpi2019;
-- ddl-end --

-- object: public.reserva_viaje | type: TABLE --
-- DROP TABLE IF EXISTS public.reserva_viaje CASCADE;
CREATE TABLE public.reserva_viaje(
	id_reserva serial NOT NULL,
	id_trayectoria serial NOT NULL,
	num_reservas integer NOT NULL,
	CONSTRAINT reserva_viaje_pk PRIMARY KEY (id_reserva)

);
-- ddl-end --
ALTER TABLE public.reserva_viaje OWNER TO tpi2019;
-- ddl-end --

-- object: public.origen | type: TABLE --
-- DROP TABLE IF EXISTS public.origen CASCADE;
CREATE TABLE public.origen(
	id_origen serial NOT NULL,
	origen varchar(100) NOT NULL,
	id_padre_origen integer,
	id_usuario serial NOT NULL,
	CONSTRAINT origen_pk PRIMARY KEY (id_origen)

);
-- ddl-end --
ALTER TABLE public.origen OWNER TO tpi2019;
-- ddl-end --

-- object: fk_rol | type: CONSTRAINT --
-- ALTER TABLE public.usuario DROP CONSTRAINT IF EXISTS fk_rol CASCADE;
ALTER TABLE public.usuario ADD CONSTRAINT fk_rol FOREIGN KEY (id_rol)
REFERENCES public.rol (id_rol) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: fk_id_conductor | type: CONSTRAINT --
-- ALTER TABLE public.medio_contacto DROP CONSTRAINT IF EXISTS fk_id_conductor CASCADE;
ALTER TABLE public.medio_contacto ADD CONSTRAINT fk_id_conductor FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: fk_id_medio_contacto | type: CONSTRAINT --
-- ALTER TABLE public.tipo_medio_contacto DROP CONSTRAINT IF EXISTS fk_id_medio_contacto CASCADE;
ALTER TABLE public.tipo_medio_contacto ADD CONSTRAINT fk_id_medio_contacto FOREIGN KEY (id_medio_contacto)
REFERENCES public.medio_contacto (id_medio_contacto) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: fk_id_conductor | type: CONSTRAINT --
-- ALTER TABLE public.vehiculo DROP CONSTRAINT IF EXISTS fk_id_conductor CASCADE;
ALTER TABLE public.vehiculo ADD CONSTRAINT fk_id_conductor FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: fk_id_vehiculo | type: CONSTRAINT --
-- ALTER TABLE public.marca DROP CONSTRAINT IF EXISTS fk_id_vehiculo CASCADE;
ALTER TABLE public.marca ADD CONSTRAINT fk_id_vehiculo FOREIGN KEY (id_vehiculo)
REFERENCES public.vehiculo (id_vehiculo) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: fk_marca | type: CONSTRAINT --
-- ALTER TABLE public.modelo DROP CONSTRAINT IF EXISTS fk_marca CASCADE;
ALTER TABLE public.modelo ADD CONSTRAINT fk_marca FOREIGN KEY (id_marca)
REFERENCES public.marca (id_marca) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: fk_id_modelo | type: CONSTRAINT --
-- ALTER TABLE public.caractetistica DROP CONSTRAINT IF EXISTS fk_id_modelo CASCADE;
ALTER TABLE public.caractetistica ADD CONSTRAINT fk_id_modelo FOREIGN KEY (id_modelo)
REFERENCES public.modelo (id_modelo) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: fk_caracteristica | type: CONSTRAINT --
-- ALTER TABLE public.tipo_caracteristica DROP CONSTRAINT IF EXISTS fk_caracteristica CASCADE;
ALTER TABLE public.tipo_caracteristica ADD CONSTRAINT fk_caracteristica FOREIGN KEY (id_caracteristica)
REFERENCES public.caractetistica (id_caracteristica) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: fk_id_conductor | type: CONSTRAINT --
-- ALTER TABLE public.trayectoria DROP CONSTRAINT IF EXISTS fk_id_conductor CASCADE;
ALTER TABLE public.trayectoria ADD CONSTRAINT fk_id_conductor FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: fk_padre | type: CONSTRAINT --
-- ALTER TABLE public.trayectoria DROP CONSTRAINT IF EXISTS fk_padre CASCADE;
ALTER TABLE public.trayectoria ADD CONSTRAINT fk_padre FOREIGN KEY (padre)
REFERENCES public.trayectoria (id_trayectoria) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --

-- object: fk_reserva | type: CONSTRAINT --
-- ALTER TABLE public.reserva_viaje DROP CONSTRAINT IF EXISTS fk_reserva CASCADE;
ALTER TABLE public.reserva_viaje ADD CONSTRAINT fk_reserva FOREIGN KEY (id_trayectoria)
REFERENCES public.trayectoria (id_trayectoria) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_usuario | type: CONSTRAINT --
-- ALTER TABLE public.origen DROP CONSTRAINT IF EXISTS fk_usuario CASCADE;
ALTER TABLE public.origen ADD CONSTRAINT fk_usuario FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id_usuario) MATCH FULL
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: fk_padre_origen | type: CONSTRAINT --
-- ALTER TABLE public.origen DROP CONSTRAINT IF EXISTS fk_padre_origen CASCADE;
ALTER TABLE public.origen ADD CONSTRAINT fk_padre_origen FOREIGN KEY (id_padre_origen)
REFERENCES public.origen (id_origen) MATCH FULL
ON DELETE CASCADE ON UPDATE CASCADE;
-- ddl-end --


