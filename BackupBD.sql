PGDMP  )    -                 |            vehicle    15.5 (Debian 15.5-1.pgdg120+1)    16.0     *           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            +           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ,           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            -           1262    16388    vehicle    DATABASE     r   CREATE DATABASE vehicle WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE vehicle;
                postgres    false            �            1259    16706    brand    TABLE     �   CREATE TABLE public.brand (
    creation_date timestamp(6) without time zone,
    id bigint NOT NULL,
    name character varying(255)
);
    DROP TABLE public.brand;
       public         heap    postgres    false            �            1259    16705    brand_id_seq    SEQUENCE     u   CREATE SEQUENCE public.brand_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.brand_id_seq;
       public          postgres    false    215            .           0    0    brand_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.brand_id_seq OWNED BY public.brand.id;
          public          postgres    false    214            �            1259    16713    model_vehicle    TABLE     �   CREATE TABLE public.model_vehicle (
    creation_date timestamp(6) without time zone,
    fk_id_brand bigint,
    id bigint NOT NULL,
    name character varying(255)
);
 !   DROP TABLE public.model_vehicle;
       public         heap    postgres    false            �            1259    16712    model_vehicle_id_seq    SEQUENCE     }   CREATE SEQUENCE public.model_vehicle_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.model_vehicle_id_seq;
       public          postgres    false    217            /           0    0    model_vehicle_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.model_vehicle_id_seq OWNED BY public.model_vehicle.id;
          public          postgres    false    216            �            1259    16720    vehicle    TABLE     �   CREATE TABLE public.vehicle (
    year integer,
    fk_id_model bigint,
    id bigint NOT NULL,
    purchase_date timestamp(6) without time zone,
    observations character varying(255),
    plate character varying(255),
    price numeric(38,2)
);
    DROP TABLE public.vehicle;
       public         heap    postgres    false            �            1259    16719    vehicle_id_seq    SEQUENCE     w   CREATE SEQUENCE public.vehicle_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.vehicle_id_seq;
       public          postgres    false    219            0           0    0    vehicle_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.vehicle_id_seq OWNED BY public.vehicle.id;
          public          postgres    false    218            �           2604    16709    brand id    DEFAULT     d   ALTER TABLE ONLY public.brand ALTER COLUMN id SET DEFAULT nextval('public.brand_id_seq'::regclass);
 7   ALTER TABLE public.brand ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            �           2604    16716    model_vehicle id    DEFAULT     t   ALTER TABLE ONLY public.model_vehicle ALTER COLUMN id SET DEFAULT nextval('public.model_vehicle_id_seq'::regclass);
 ?   ALTER TABLE public.model_vehicle ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217            �           2604    16723 
   vehicle id    DEFAULT     h   ALTER TABLE ONLY public.vehicle ALTER COLUMN id SET DEFAULT nextval('public.vehicle_id_seq'::regclass);
 9   ALTER TABLE public.vehicle ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    218    219            #          0    16706    brand 
   TABLE DATA           8   COPY public.brand (creation_date, id, name) FROM stdin;
    public          postgres    false    215          %          0    16713    model_vehicle 
   TABLE DATA           M   COPY public.model_vehicle (creation_date, fk_id_brand, id, name) FROM stdin;
    public          postgres    false    217   W       '          0    16720    vehicle 
   TABLE DATA           c   COPY public.vehicle (year, fk_id_model, id, purchase_date, observations, plate, price) FROM stdin;
    public          postgres    false    219   �       1           0    0    brand_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.brand_id_seq', 1, true);
          public          postgres    false    214            2           0    0    model_vehicle_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.model_vehicle_id_seq', 1, true);
          public          postgres    false    216            3           0    0    vehicle_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.vehicle_id_seq', 5, true);
          public          postgres    false    218            �           2606    16711    brand brand_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.brand
    ADD CONSTRAINT brand_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.brand DROP CONSTRAINT brand_pkey;
       public            postgres    false    215            �           2606    16718     model_vehicle model_vehicle_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.model_vehicle
    ADD CONSTRAINT model_vehicle_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.model_vehicle DROP CONSTRAINT model_vehicle_pkey;
       public            postgres    false    217            �           2606    16727    vehicle vehicle_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.vehicle
    ADD CONSTRAINT vehicle_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.vehicle DROP CONSTRAINT vehicle_pkey;
       public            postgres    false    219            �           2606    16733 #   vehicle fkj4anrhvk6wk31jp2ptuk428n3    FK CONSTRAINT     �   ALTER TABLE ONLY public.vehicle
    ADD CONSTRAINT fkj4anrhvk6wk31jp2ptuk428n3 FOREIGN KEY (fk_id_model) REFERENCES public.model_vehicle(id);
 M   ALTER TABLE ONLY public.vehicle DROP CONSTRAINT fkj4anrhvk6wk31jp2ptuk428n3;
       public          postgres    false    217    3215    219            �           2606    16728 )   model_vehicle fks6yo6xl73yb9n0199vxb27sf6    FK CONSTRAINT     �   ALTER TABLE ONLY public.model_vehicle
    ADD CONSTRAINT fks6yo6xl73yb9n0199vxb27sf6 FOREIGN KEY (fk_id_brand) REFERENCES public.brand(id);
 S   ALTER TABLE ONLY public.model_vehicle DROP CONSTRAINT fks6yo6xl73yb9n0199vxb27sf6;
       public          postgres    false    217    215    3213            #   *   x�3202�50�50Q0��2� "=#NC��H�G�=... ��      %   .   x�3202�50�50Q0��2��20�36�4Bg� G�=... ���      '   �   x�m�;
�0��)r��!)����7���*)���fx+@!&!���>�=��m��{��4�&F�����5�E��_?�f�	<�Y��}u��_��,�Hx��+���j�dڴ&naI!�/,�,     