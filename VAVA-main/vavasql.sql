PGDMP         -                z           Vava    14.1    14.1                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    34404    Vava    DATABASE     d   CREATE DATABASE "Vava" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Slovak_Slovakia.1250';
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
       public          postgres    false    210                       0    0    accounts_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.accounts_id_seq OWNED BY public.accounts.id;
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
       public          postgres    false    211                       0    0    logs_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.logs_id_seq OWNED BY public.logs.id;
          public          postgres    false    212            e           2604    34439    accounts id    DEFAULT     j   ALTER TABLE ONLY public.accounts ALTER COLUMN id SET DEFAULT nextval('public.accounts_id_seq'::regclass);
 :   ALTER TABLE public.accounts ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    209    210            f           2604    34440    logs id    DEFAULT     b   ALTER TABLE ONLY public.logs ALTER COLUMN id SET DEFAULT nextval('public.logs_id_seq'::regclass);
 6   ALTER TABLE public.logs ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    211            �          0    34425    accounts 
   TABLE DATA           W   COPY public.accounts (id, firstname, lastname, password, email, sex, date) FROM stdin;
    public          postgres    false    210   5       �          0    34443    children 
   TABLE DATA           1   COPY public.children (id, parent_id) FROM stdin;
    public          postgres    false    213   e       �          0    34433    logs 
   TABLE DATA           G   COPY public.logs (id, email, password, ip, status, "time") FROM stdin;
    public          postgres    false    211   �                  0    0    accounts_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.accounts_id_seq', 10, true);
          public          postgres    false    209            	           0    0    logs_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.logs_id_seq', 50, true);
          public          postgres    false    212            h           2606    34432    accounts accounts_email_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_email_key UNIQUE (email);
 E   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_email_key;
       public            postgres    false    210            j           2606    34430    accounts accounts_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.accounts DROP CONSTRAINT accounts_pkey;
       public            postgres    false    210            n           2606    34447    children children_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.children
    ADD CONSTRAINT children_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.children DROP CONSTRAINT children_pkey;
       public            postgres    false    213            l           2606    34442    logs logs_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.logs
    ADD CONSTRAINT logs_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.logs DROP CONSTRAINT logs_pkey;
       public            postgres    false    211            o           2606    34448     children children_parent_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.children
    ADD CONSTRAINT children_parent_id_fkey FOREIGN KEY (parent_id) REFERENCES public.accounts(id);
 J   ALTER TABLE ONLY public.children DROP CONSTRAINT children_parent_id_fkey;
       public          postgres    false    210    213    3178            �      x�m��n�0���S�Z%)I[N&4�!�v1%����J�O?��4�q���ى����
_�T���]��c��N+j`��U�:��D�B��n� ����T�+8э�1w�&
�JSY�ZJ)��Ɲ�6�����&&�y�*)\���B{���|�Wưl�Ya`K�/���Ù.W"u�܉׮����V+l�z�N�#Γ�vp�,��m��
�᥊�z���q���?��\��p����]����,��T�Tr�M"s�$l�����'l�D���E"�k��H��T��      �      x�3�4�2bsNC.���� $�      �   @  x����NA���S̍C�V���H�x�\�"'��1)O��j���Q:²��?j��*p��y�o���4������i~�<9����;�l���a@��c�!��>>�B�0��7_7�c �,H<b�1�G �#��K�$RI�����p���k�.g��G&,�^���<����H4�E8@���no�ݼ?ϛۇix9N�q)����ƌ��,�#��~�{�l��ާG�Q`��	�-��ܥ(�~-��Z�đ�~��s?q�چ���:y��c�\�}<#OYbj���y�������r�UF���90I6u��V�a2������ƞ�e��hi�TX&�d,�a��UV\m< ���Ȩ�[������>o^�T6�g#�U���OT0���Z��W�Z��Ji���Ll�I��U��N�����U���MB`͕��d�x�5[:uR�G�j�:�)s.��ʭ#V��A~���Y�T;,���T��&6�Z���+�s�O�;eEj�FY��� ��E�Fd%ƌ���@�:yLX؜����R�'�J��L�����edu񱤔�3���Y��L*��@�ޠI�R�S.�v�v:@H�ꔋ���R[$}�d�Z|������d�uwK�&QZ�M0K�7K�[[��YgQ-��\Z���.ۈ|b}�6 ����5��+6ܼtM�F��="�"��=u��k�^��ň�K�h�O��[���r��Wi��`��W�e�H�xU�܈���Dd%������W�e��z��Cj��?�JS��t6_�>�T"��>F�o]�K%�,�g)�Mҧ��S��Q��"V�guu��˸�     