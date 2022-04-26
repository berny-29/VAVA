PGDMP     %        
            z           Vava    14.1    14.1                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    34404    Vava    DATABASE     d   CREATE DATABASE "Vava" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Slovak_Slovakia.1250';
    DROP DATABASE "Vava";
                postgres    false            �            1259    34425    accounts    TABLE     ,  CREATE TABLE public.accounts (
    id integer NOT NULL,
    firstname character varying(50) NOT NULL,
    lastname character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    email character varying(255) NOT NULL,
    sex character varying(20),
    date character varying(30)
);
    DROP TABLE public.accounts;
       public         heap    postgres    false            �            1259    34424    accounts_id_seq    SEQUENCE     �   CREATE SEQUENCE public.accounts_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.accounts_id_seq;
       public          postgres    false    210                       0    0    accounts_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.accounts_id_seq OWNED BY public.accounts.id;
          public          postgres    false    209            �            1259    34443    children    TABLE     O   CREATE TABLE public.children (
    id bigint NOT NULL,
    parent_id bigint
);
    DROP TABLE public.children;
       public         heap    postgres    false            �            1259    34433    logs    TABLE     �   CREATE TABLE public.logs (
    id bigint NOT NULL,
    email character varying NOT NULL,
    password character varying NOT NULL,
    ip character varying NOT NULL,
    status character varying NOT NULL,
    "time" timestamp with time zone NOT NULL
);
    DROP TABLE public.logs;
       public         heap    postgres    false            �            1259    34438    logs_id_seq    SEQUENCE     t   CREATE SEQUENCE public.logs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.logs_id_seq;
       public          postgres    false    211                       0    0    logs_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.logs_id_seq OWNED BY public.logs.id;
          public          postgres    false    212            �            1259    34454    tasks    TABLE     �   CREATE TABLE public.tasks (
    id integer NOT NULL,
    repetitive boolean,
    description character varying(50),
    start_date timestamp without time zone,
    end_date timestamp without time zone,
    account_id bigint,
    child_id bigint
);
    DROP TABLE public.tasks;
       public         heap    postgres    false            �            1259    34453    tasks_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tasks_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.tasks_id_seq;
       public          postgres    false    215                       0    0    tasks_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.tasks_id_seq OWNED BY public.tasks.id;
          public          postgres    false    214            j           2604    34439    accounts id    DEFAULT     j   ALTER TABLE ONLY public.accounts ALTER COLUMN id SET DEFAULT nextval('public.accounts_id_seq'::regclass);
 :   ALTER TABLE public.accounts ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    210    210            k           2604    34440    logs id    DEFAULT     b   ALTER TABLE ONLY public.logs ALTER COLUMN id SET DEFAULT nextval('public.logs_id_seq'::regclass);
 6   ALTER TABLE public.logs ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    211            l           2604    34457    tasks id    DEFAULT     d   ALTER TABLE ONLY public.tasks ALTER COLUMN id SET DEFAULT nextval('public.tasks_id_seq'::regclass);
 7   ALTER TABLE public.tasks ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215                      0    34425    accounts 
   TABLE DATA           W   COPY public.accounts (id, firstname, lastname, password, email, sex, date) FROM stdin;
    public          postgres    false    210   �"       	          0    34443    children 
   TABLE DATA           1   COPY public.children (id, parent_id) FROM stdin;
    public          postgres    false    213   $                 0    34433    logs 
   TABLE DATA           G   COPY public.logs (id, email, password, ip, status, "time") FROM stdin;
    public          postgres    false    211   3$                 0    34454    tasks 
   TABLE DATA           h   COPY public.tasks (id, repetitive, description, start_date, end_date, account_id, child_id) FROM stdin;
    public          postgres    false    215   �*                  0    0    accounts_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.accounts_id_seq', 10, true);
          public          postgres    false    209                       0    0    logs_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.logs_id_seq', 117, true);
          public          postgres    false    212                       0    0    tasks_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.tasks_id_seq', 1, false);
          public          postgres    false    214            n           2606    34432    accounts accounts_email_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_email_key UNIQUE (email);
 E   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_email_key;
       public            postgres    false    210            p           2606    34430    accounts accounts_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_pkey;
       public            postgres    false    210            t           2606    34447    children children_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.children
    ADD CONSTRAINT children_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.children DROP CONSTRAINT children_pkey;
       public            postgres    false    213            r           2606    34442    logs logs_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.logs
    ADD CONSTRAINT logs_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.logs DROP CONSTRAINT logs_pkey;
       public            postgres    false    211            v           2606    34459    tasks tasks_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.tasks DROP CONSTRAINT tasks_pkey;
       public            postgres    false    215            w           2606    34448     children children_parent_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.children
    ADD CONSTRAINT children_parent_id_fkey FOREIGN KEY (parent_id) REFERENCES public.accounts(id);
 J   ALTER TABLE ONLY public.children DROP CONSTRAINT children_parent_id_fkey;
       public          postgres    false    210    3184    213            x           2606    34460    tasks tasks_account_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_account_id_fkey FOREIGN KEY (account_id) REFERENCES public.accounts(id);
 E   ALTER TABLE ONLY public.tasks DROP CONSTRAINT tasks_account_id_fkey;
       public          postgres    false    215    3184    210            y           2606    34465    tasks tasks_child_id_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_child_id_fkey FOREIGN KEY (child_id) REFERENCES public.accounts(id);
 C   ALTER TABLE ONLY public.tasks DROP CONSTRAINT tasks_child_id_fkey;
       public          postgres    false    3184    210    215               "  x�m��n�0���S�@Ih���TM�*�v14�� �(T�O���6.�c��g'����L�(�wә6L��.5�*.��#VD�ˈo"��dn�ca�	�}EB&��+�4hg�i��op� u�M>�+��'�L3Gj�Cx1s�otG�}&P��B�7�L݌k�Ւ�8?b�Y�Z��
������!-�ˀ��¡��/���	� O�m���h�L�=0��I�[��RE<e���?����`���E��b�0gxm�s`���?���Z�Y��c��ae�3ƾ�>��      	   !   x�3�4�2bsNC.a�i�e�1z\\\ ?��         �  x����N\G�ׇ���QZ]��)�ב��xa���<}��:N��B\�������M��������p�;�����p�iw���M�9D����tu�{�82���h��s�x�%�O_w߮>�u����ĢS�@b�9��_"�7�3��5X�l�H6}����.7������RB��U�M�����(��u���j)5J�./�O����q{�u�yz�֑�l4!fn���1�gk��_]?n�^�^.O6�g��K�q�iz/
m�mV�z�$�~��p�q�HCa�d��<���)J��Gc<��� �R��x�����?��뽽Ϫ��?�*V:JP;D��t�N�O��w���꟭HiE�Q�,a�Y!+���xP��Y/��|�y:|�v����o��M
E�ʪp^�9��@0���,m��7J��k�����H3��U��^<�Vp�Q�J�J��b�̈́��	u1�GKX�����!�)����T{�b9�s눭r�h�u��a�VNԉo�`�����*^]9�����^e ��֏2JQ� O��Av���
wmpb�9p檽��)��"���)
��<ˋ�p
x|�B�9���@�b�.�Q��ڀE�Z�8(��{=2)���ֶ�M�7�1b�嵆J����Mɬ%�w[mE�z�.�S��$KK�y�YD��+���f�u�Ő��@V�����J?�z�M�&�� Q��&�)?�>m��9Ky�D%r��+�*��C�+mu,�V���r�(Xx;��ŉ��r�� RH������r���o!���!h�a�,��z]�1�4"5o���%+criD�E
j5�i�1�0��
��:�M��A�`�MmN�X��}ԋ� ��Jt�^��E8]�����n�3����G	b�s/6(�5@3-�m�;I�#�T�c�̭�bċ�8(]��,�iP0 �,�EoiP0�xF�ԇ�4� s3��Q���^���N���]82��i��t"J�)%�&Ӡf������Ԍ��\G��e�À�m(]{�NÒAG�0Cg�\KN��2�oc�<D�(�E�9�yuӦߕ��FK��d�	�лQ~G�'d�%7��2k�ڌ^e��@Q�a�
�x7)��j�O��W7���ܦ��u�r����]�l�o�bY���r�,���<D�f����bR+I�}r�uh=+�Щײ�V�K6�u -@V0�i����2�q�(y(J � �9�_��8�R���²�(O[��bZ�Q`���ƕ<��3��&��1UW`�1��$�����	�����`m�UĖ�`������r�.�J�@i�^"�pT,��!�w�:&��̲��F�e��W˹�@���s򑿎���UNV|�c���[�*��v��)�?��=����z�;���i���r�SO��6�m��BH�?$��<�m���]���X��b@�9R��d]�c��]2�1L�9��3�\oϯ�@�61d���8�c��[n�O8����~�����lj�M��R����s^��J�ݠP,�𣏕�sõ�\+�%�Ǥs^���d���et�i�YD��Ԭ/[y�y�y��n�u���e�E
�yyv��,�I�a2���ʶ��±Y�<dn�=$�w�Dc�i���H�z9':vp���KZbSN��Tr�����pqq��(�            x������ � �     