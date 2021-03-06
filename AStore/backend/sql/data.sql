INSERT INTO AStore.role (id, name)
VALUES (1, 'admin'),
       (2, 'content_manager'),
       (3, 'user');

INSERT INTO AStore.user (id, username, password, role_id)
VALUES (1, 'Aslan', 'Aslan', 1),
       (2, 'Alex', 'Alex', 2),
       (3, 'Roman', 'Roman', 3),
       (4, 'Ivan', 'Ivan', 3);

INSERT INTO AStore.userinfo (id, name, dateofbirth, user_id)
VALUES (1, 'Aslan', '2000-08-22', 1),
       (2, 'Alex', '1999-05-12', 2),
       (3, 'Roman', '2000-02-04', 3),
       (4, 'Ivan', '1998-11-27', 4);

INSERT INTO AStore.wallet (id, userid, name, description, value)
VALUES (1, 1, 'First', 'First wallet of admin Aslan', 330),
       (2, 1, 'Second', 'Second wallet of admin Aslan', 127),
       (3, 2, 'Wallet', 'First wallet of content manager Alex', 507),
       (4, 3, 'Romha', 'First wallet of user Roman', 400),
       (5, 4, 'Ivanov', 'A wallet of user Ivan', 394.5);

INSERT INTO AStore.category (id, name)
VALUES (1, 'Text editors'),
       (2, 'Graphic editors'),
       (3, 'Video editors');

INSERT INTO AStore.product (id, category_id, wallet_id, name, description, cost)
VALUES (1, 1, 3, 'Sublime Text',
        'It’s a well-turned and sophisticated text editors for writing good quality and error free code. It has Multiple selections that allow you to interactively change many lines at once, rename variables with ease, and manipulate files faster than ever. It just natively supports many programming and markup languages. You can also add more functions just by using its plugin.
       Sublime Text gives you such powerful python based API with Python console to interactively experiment in real time. It is a lightweight text editor which supports on Windows, Mac, and Linux. It has launched three versions so far with exclusive code writing features.',
        30),
       (2, 1, 3, 'Atom',
        'If you are one of those who doesn’t like restrictions on their work/programming then this is the right text editor for you. Atom is a fully customizable text editor, so you can do anything with it by choosing different packages to add new functionality and features to it. So it’s kind of more open source for you to add desired functions on it which just basically means adding functions to make your coding more convenient.
       You don’t have to worry about which platform you are using if you are willing to use this text editor because it works on Windows, Mac, and Linux as well.',
        49.9),
       (3, 1, 3, 'Coda',
        'Coda is one of the paid text editors for Mac. Because it’s specialized for Mac so it has so many features that would like to try if you are a Mac user.
       Syntax highlighting on Coda is much faster than any other text editor. You can preview your code in real-time. Coda has too many rich utilities that make your work better.',
        23.9),
       (4, 1, 3, 'Notepad++',
        'Notepad++ is a source text editor that helps to write programs in an easy way. It has such powerful editing component  Scintilla, it helps and supports during editing, debugging code indicates errors and much more. This text editor is purely written in C++. It uses pure Win32 API and STL which ensures a higher execution speed and smaller program size for every code you write. You can change the editor language to your native language just by downloading and updating the XML file. The best part which every programmer likes about notepad++ is that it is one of the very lightweight software with extreme features.',
        4.9),
       (5, 1, 3, 'Visual Studio Code',
        'Visual Studio Code is a source code editor developed by Microsoft for Windows, Linux and macOS. It includes support for debugging, embedded Git control, syntax highlighting, intelligent code completion, snippets, and code refactoring. It is also customizable, so users can change the editors theme, keyboard shortcuts, and preferences. It is free and open-source, although the official download is under a proprietary license.
       Visual Studio Code is based on Electron, a framework which is used to deploy Node.js applications for the desktop running on the Blink layout engine. Although it uses the Electron framework, the software does not use Atom and instead employs the same editor component (codenamed "Monaco") used in Visual Studio Team Services (formerly called Visual Studio Online).',
        59.9),
       (6, 1, 3, 'UltraEdit',
        'As the name specifies, UltraEdit is one of the text editor which comes with some ordinary editing features which every coder should try.
       It is a multi-platform text editor for web development, text editing, system administration and desktop development. It is a Bunch of Incredible features to handle sophisticated software and web development projects. It has very flexible and customized interface. Even it is a paid text editor but you can take trail as well.',
        19.9),
       (7, 1, 3, 'Brackets',
        'Brackets is another open source text/code editor with proper visual tools and preprocessor. It is very lightweight and sufficient for a beginner programmer. With a lot of functions as real-time editing preview and some features, it is a complete coding hub for a programmer. You can even get a real-time connection to your browser. You can also make changes to CSS and HTML and you will instantly see those changes on your screen.',
        59.9),
       (8, 1, 3, 'CodeRunner',
        'If you are a Mac user then, it is pretty sure that CodeRunner is for you. It’s a purely Mac based text editor, supports large amount of languages. It is very lightweighted and Working on CodeRunner it very ingenue. With so many reliable features it also provides the easily and fully customizable templates to each language.',
        9.9),
       (9, 2, 3, 'GIMP',
        'GIMP (GNU Image Manipulation Program) is a open-source raster graphics editor used for image retouching and editing, free-form drawing, converting between different image formats, and more specialized tasks.
       GIMP is released under GPLv3+ licenses and is available for Linux, macOS, and Microsoft Windows. GIMP is primarily developed by volunteers as a free software project associated to both the GNU and GNOME Projects. Development takes place in a public git source code repository, on public mailing lists and in public chat channels on the GIMPNET IRC network.',
        24.9),
       (10, 2, 3, 'Adobe Photoshop',
        'Adobe Photoshop is a raster graphics editor developed and published by Adobe Systems for macOS and Windows.
       Photoshop was created in 1988 by Thomas and John Knoll. Since then, it has become the de facto industry standard in raster graphics editing, to the point that Photoshop has become a generic trademark leading to its use as a verb such as "to Photoshop an image," "photoshopping" and "photoshop contest", though Adobe discourages such use. It can edit and compose raster images in multiple layers and supports masks, alpha compositing and several color models including RGB, CMYK, CIELAB, spot color and duotone. Photoshop has vast support for graphic file formats but also uses its own PSD and PSB file formats which support all the aforementioned features. In addition to raster graphics, it has limited abilities to edit or render text, vector graphics (especially through clipping path), 3D graphics and video. Photoshops feature set can be expanded by Photoshop plug-ins, programs developed and distributed independently of Photoshop that can run inside it and offer new or enhanced features.',
        79.9),
       (11, 2, 3, 'Paint.NET',
        'Paint.net (stylized as Paint.NET or paint.net) is a raster graphics editor program for Microsoft Windows, developed on the .NET Framework. Paint.net was originally created by Rick Brewster as a Washington State University student project, and has evolved from a simple replacement for the Microsoft Paint program into an editor with support for layers, blending, transparency, and plugins.',
        10),
       (12, 3, 3, 'Adobe Premiere Pro',
        'Adobe Premiere Pro is a timeline-based video editing app developed by Adobe Systems and published as part of the Adobe Creative Cloud licensing program. First launched in 2003, Adobe Premiere Pro is a successor of Adobe Premiere (first launched in 1991). It is geared towards professional video editing, while its sibling, Adobe Premiere Elements, targets consumers market.
       CNN was an early adopter of Adobe Premiere. Also, in 2007, certain BBC departments adopted Premiere. It has been used to edit feature films, such as Deadpool, Gone Girl, Captain Abu Raed, and Monsters, and other venues such as Madonnas Confessions Tour.',
        119.9),
       (13, 3, 3, 'Final Cut Pro',
        'Final Cut Pro is a series of non-linear video editing software programs first developed by Macromedia Inc. and later Apple Inc. The most recent version, Final Cut Pro X 10.4.4, runs on Intel-based Mac computers powered by macOS High Sierra or later. The software allows users to log and transfer video onto a hard drive (internal or external), where it can be edited, processed, and output to a wide variety of formats. The fully rewritten Final Cut Pro X was introduced by Apple in 2011, with the last version of the legacy Final Cut Pro being version 7.0.3.',
        119.9),
       (14, 3, 3, 'Vegas Pro',
        'Vegas Pro (also stylized as VEGAS Pro) is a video editing software package for non-linear editing (NLE) originally published by Sonic Foundry, then by Sony Creative Software, and now by Magix. The software runs on the Windows operating system.
       Originally developed as audio editing software, it eventually developed into an NLE for video and audio from version 2.0. Vegas features real-time multitrack video and audio editing on unlimited tracks, resolution-independent video sequencing, complex effects and compositing tools, 24-bit/192 kHz audio support, VST and DirectX plug-in effect support, and Dolby Digital surround sound mixing. On 24 May 2016, Sony announced that it had sold Vegas (and most of its "Creative Software" line) to MAGIX, who would continue supporting and developing the software.',
        89.9),
       (15, 3, 3, 'Adobe After Effects',
        'Adobe After Effects is a digital visual effects, motion graphics, and compositing application developed by Adobe Systems and used in the post-production process of film making and television production. Among other things, After Effects can be used for keying, tracking, compositing and animation. It also functions as a very basic non-linear editor, audio editor and media transcode.',
        79.9);

INSERT INTO AStore.subscription (id, prod_id, user_wallet_id, start, end, is_active)
VALUES (1, 1, 4, '2019-11-10', '2019-12-22', 1),
       (2, 7, 4, '2019-12-10', '2019-12-22', 1),
       (3, 4, 5, '2019-11-09', '2020-02-09', 1);
