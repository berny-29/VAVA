PGDMP         /                z           Vava    14.1    14.1                 0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    34404    Vava    DATABASE     d   CREATE DATABASE "Vava" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Slovak_Slovakia.1250';
    DROP DATABASE "Vava";
                postgres    false            ?            1259    34425    accounts    TABLE     ,  CREATE TABLE public.accounts (
    id integer NOT NULL,
    firstname character varying(50) NOT NULL,
    lastname character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    email character varying(255) NOT NULL,
    sex character varying(20),
    date character varying(30)
);
    DROP TABLE public.accounts;
       public         heap    postgres    false            ?            1259    34424    accounts_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.accounts_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.accounts_id_seq;
       public          postgres    false    210                       0    0    accounts_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.accounts_id_seq OWNED BY public.accounts.id;
          public          postgres    false    209            ?            1259    34443    children    TABLE     O   CREATE TABLE public.children (
    id bigint NOT NULL,
    parent_id bigint
);
    DROP TABLE public.children;
       public         heap    postgres    false            ?            1259    34433    logs    TABLE     ?   CREATE TABLE public.logs (
    id bigint NOT NULL,
    email character varying NOT NULL,
    password character varying NOT NULL,
    ip character varying NOT NULL,
    status character varying NOT NULL,
    "time" timestamp with time zone NOT NULL
);
    DROP TABLE public.logs;
       public         heap    postgres    false            ?            1259    34438    logs_id_seq    SEQUENCE     t   CREATE SEQUENCE public.logs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.logs_id_seq;
       public          postgres    false    211                       0    0    logs_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.logs_id_seq OWNED BY public.logs.id;
          public          postgres    false    212            ?            1259    34454    tasks    TABLE       CREATE TABLE public.tasks (
    id integer NOT NULL,
    repetitive boolean,
    description character varying(50),
    start_date timestamp without time zone,
    end_date timestamp without time zone,
    account_id bigint,
    child_id bigint,
    status character varying(20)
);
    DROP TABLE public.tasks;
       public         heap    postgres    false            ?            1259    34453    tasks_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.tasks_id_seq
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
    public          postgres    false    210   ?"       	          0    34443    children 
   TABLE DATA           1   COPY public.children (id, parent_id) FROM stdin;
    public          postgres    false    213   >$                 0    34433    logs 
   TABLE DATA           G   COPY public.logs (id, email, password, ip, status, "time") FROM stdin;
    public          postgres    false    211   u$                 0    34454    tasks 
   TABLE DATA           p   COPY public.tasks (id, repetitive, description, start_date, end_date, account_id, child_id, status) FROM stdin;
    public          postgres    false    215   -                  0    0    accounts_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.accounts_id_seq', 11, true);
          public          postgres    false    209                       0    0    logs_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.logs_id_seq', 156, true);
          public          postgres    false    212                       0    0    tasks_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.tasks_id_seq', 8, true);
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
       public            postgres    false    215            w           2606    34448     children children_parent_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.children
    ADD CONSTRAINT children_parent_id_fkey FOREIGN KEY (parent_id) REFERENCES public.accounts(id);
 J   ALTER TABLE ONLY public.children DROP CONSTRAINT children_parent_id_fkey;
       public          postgres    false    210    3184    213            x           2606    34460    tasks tasks_account_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_account_id_fkey FOREIGN KEY (account_id) REFERENCES public.accounts(id);
 E   ALTER TABLE ONLY public.tasks DROP CONSTRAINT tasks_account_id_fkey;
       public          postgres    false    215    3184    210            y           2606    34465    tasks tasks_child_id_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY public.tasks
    ADD CONSTRAINT tasks_child_id_fkey FOREIGN KEY (child_id) REFERENCES public.accounts(id);
 C   ALTER TABLE ONLY public.tasks DROP CONSTRAINT tasks_child_id_fkey;
       public          postgres    false    3184    210    215               5  x?m??n?0???S?Z%)	-'BlH{?]L?AH[O?E*O??T?z?;>???\??r]??\??xpm?>?諴??X9PE??Hd!????x??H????`F??Z%ł3-]???P?8??eZ?l?Ya`O?[wt???5g"?^yo\=Qc?V?H?ĕ?-F?'k??p?$\?k?%2??k?Uh????a???29?G???v=?G??L?~R?Jɕ6?\
%a?+?`?!??!m????D??`G7?	/-va ?;_???t#c̃p?U?4?EGJ?????8q?C>?9??V??
!?K??I      	   '   x?3?4?2bsNC.a?i?eĆ???\1z\\\ Z??         ?  x????n\9??'O?]/-?7I,????7?M?qf܎]F9A?~?!E???*??1?ĩ|?D??H??????????xwsLׇ????????~?? ֔?,O߯?o?̈?e?-?U?]???k??|??q??????ۯ?H?4I@?s*?g???9I?*?$Y?8?yX>]?r8^????Zj9!S????ߏ7???U??.sR??)e??i?|<<^}??zs????????v???ٌN??y?????????O???GWPw;l????Ֆ?-+??Y?ۮW.?????V<???c?!O???$,??v?? ?H5)5??????????|??Y?㲳??L?:?&P?v.ea?,^???o>???????jpX#??Y2ê;6Y?2???2k;F?i?U???????}???F0ٔ?X, :?m2?????&Ԧci3??<K1?jV???|?6?j????.?W	ų??e?Vl?=?fh ;???t!?E+?Zz?I?
xŒ?Ek-?3ҙ??F?̑??E?Y"63?ҡb?N<??4??k?۠Ev?rʾ????
eC?JeKE?????D6biص?mh??	+*?L??????Փ?$??L???s??md????Z?g?"7#*u???s?-??qR.??z?t?\?chR.F?F?Q4H戵?WM
?0\}R2[?V?E=Ih??9G)q?-??l?h)"j.m???,Dɩ???W ڤ?s?p4?Wzp??nj?X?(a?D>?O?M?????f~?D?%b???????Mzy?h]????K=o??9"??=T	[7??????u?]/?I/g?l?[?%?(\??BͲ??d50?"??ŉ??})\?W???D?EH,Z?i?9? xM?V???mb'N??&??s斣?ˤ^b?5????8???h?.? ?D?ux?F?Lr?&?bD?GJ$???"dR,F$/?"ܢC?M??Y???PJ??qR0??Lf?}(???1bH??qjP&cD??b?b??2)=?}4??2?Vo??%F
?)???m?p???0?y:?)?d??DKe?Pb?,?????XC???_Oj?<?????(YeR3FD?l?֞?˴d?"PN6CW_OK?:e???!?6?i?XO?d",P? ?ɼ??r??Jw?|m%{??gDoZ????P??H??L?يdo?	Ko ??j?h?^??MJ]S????????Fb?)!?????埇?ۻ???? ????~9S???N?X??
?8v???E!??ܪ??{?&t蹬?I?4?`?b?:??k????vD???8e?? ?5K??<PJR?q`?x???h?\??2???*????/>?'?EC?mN0??_q8zN0l>?Kd˞??+?uN0???D????KZaH??X/Q[X8+(?!?W,?K?f???f????W˥qh@knkb?%F~?SK?V?H?%ϕ??O?kR??tU???/!r???)Q/???vQ]+֐٤:w?LC???8????\??y?'???k?q?kQ?s?1"?2?'? ?IF?d?5????fn???ZC??Fh??@??1A???S???o??D1F?yN6?C?Pbmm\???9?2???-G??-?،\??PUE?^??ef???r??2X????h#!x??c+W??/#V??f??q??6?\??~?ЊWx?f??H???֚QV??Nam??Y????`N8NT43?t?vpč????????Jm?#_?˚???.?9???? ??QG?
?5?Z]s?PdJ??L?????c?????????(????|ԑ=m?G>? .C?-l????I??G?V ????v???M?44) ?GD?0+?8????󤖘???km?e?~dJb??@??@Ϙ?T??p????x{(/?x?A)??%)??~???f???͌e"??,O?ZndF??b4C?? N??u?r:?bl???-???s??8????a?j:?llΟ??	qX?ޛ?g??/?6???+?m8S?Z??S????ƕ?r???Y?wP~?!?b???Vo?/PnG????2'+JQ?%	0š:???_?T?P`T}~R9YQ?U?????????e@???2??????eH??Z????z????!Ș\?-?9<??r????޵M=	?#j_?|D9a???⪉ԏR??F?ɑ<	?e{??g ?xݻ'??K?1&p8i_??4?x?*4??Q?q?cΞj?FTGԈ???6??OdX&??{X4G??W??????@~         ?   x???A
? е?"H'?1s?? C(?
֒?w4PRI6ſ|?|%f????;
??u?4p~fqx??7?L???t?j??W?4??R??a>{G?,?3p-,!?l?v?/7????G;gW~?{HU͇iwR?9??'????؜l?k)5????RX)?b?Z?     