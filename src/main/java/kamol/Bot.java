package kamol;

import org.checkerframework.checker.units.qual.Length;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            System.err.println("Bot ishlamadi");
        }
    }

    @Override
    public String getBotUsername() {
        return BotConfig.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BotConfig.BOT_TOKEN;
    }

    private static final Long ADMIN_CHAT_ID = 1414865748L;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String text = message.getText();
            String chatId = message.getChatId().toString();
            Integer messageId = message.getMessageId();
            User from = message.getFrom();
            if (message.hasText()) {
                if (text.equals("/start")) {
                    sendMsg(chatId, "Salom Hush kelibsiz" + from.getFirstName(), messageId);
                    getBtn(chatId, "Tanlang", messageId, BotConfig.START_BTN);
                    BotConfig.STATISTIK.add(chatId);
                } else if (text.equals("Bot haqida\uD83D\uDCDC")) {
                    sendMsg(chatId, "Ushbu OLX bot orqali siz har hil turdagi mashinalarni sotib olishingiz mumkun", messageId);
                } else if (text.equals("Biz bilan bog'lanish\uD83D\uDC64")) {
                    sendMsg(chatId, "@Suxa_kooo yokida +998886184041 raqamiga murojat qilishingiz mumkun ish vaqti 24/7", messageId);
                } else if (text.equals("Statistika♐")) {
                    sendMsg(chatId, "Ushbu bottan" + BotConfig.STATISTIK.size() + "ta foydalanuvchi", messageId);
                } else if (text.equals("Mashinalar\uD83D\uDE98")) {
                    getBtn(chatId, "Tanlang", messageId, BotConfig.CARS);
                } else if (text.equals("ORQAGA↪.")) {
                    getBtn(chatId, "Tanlang", messageId, BotConfig.START_BTN);
                } else if (text.equals("CHEVROLIT")) {
                    getBtn(chatId, "Tanlang", messageId, BotConfig.SHEVROLIT);
                } else if (text.equals("BMW")) {
                    getBtn(chatId, "Tanlang", messageId, BotConfig.BMW);
                } else if (text.equals("orqaga↪")) {
                    getBtn(chatId, "Tanlang", messageId, BotConfig.CARS);
                } else if (text.equals("MERSEDIS")) {
                    getBtn(chatId, "Tanlang", messageId, BotConfig.MERSEDIS);
                } else if (text.equals("KIA")) {
                    getBtn(chatId, "Tanlash", messageId, BotConfig.KIYA);
                } else if (text.equals("BYD")) {
                    getBtn(chatId, "Tanlang", messageId, BotConfig.BYD);
                }else if (text.equals("YUQ❌")) {
                    getBtn(chatId, "Tanlang", messageId, BotConfig.CARS);
                }else if (text.equals("HA✔")) {
                    getBtn(chatId, "Tanlang", messageId, BotConfig.STT);
//                    if (text.trim().length()==16){
                }else if (text.equals("TASDIQLANDI✔")){
                    getBtn(chatId, "tanlang", messageId, BotConfig.CARS);
                }else if (text.equals("ORQAGA↪")){
                    getBtn(chatId, "tanlang", messageId, BotConfig.CARS);

//                    else {
//                        sendMsg(chatId, "xato", messageId);
//                    }
                    sendMsg(chatId, "plastik raqamingizni junating", messageId);


                } else if (text.equals("cobalt")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Cobalt“ 1,5 litr hajmdagi to‘rt silindrli, benzin bilan ishlaydigan 106 ot kuchi quvvatiga ega va 5 bosqichli mexanik uzatmali dvigatel bilan jihozlangan. 100 kilometrga taxminan 6,2 litr yoqilg‘i sarflaydi. Rivojlanib borayotgan bozorlarda bu avtomobil B turkumiga kiruvchi yagona model bo‘ladi. Bundan tashqari, uning 6 bosqichli avtomat transmissiya o‘rnatilgan rusumi ham mavjud.\uD83E\uDD11Narxi COBALT LTZ. 164 521 000 сум");
                    sendPhoto.setPhoto(new InputFile("https://avtoexperts.ru/wp-content/uploads/pjqa8S6Z.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }


                } else if (text.equals("jentra")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Daewoo Gentra-bu Janubiy Koreyaning Daewoo avtomobil brendi tomonidan ishlatiladigan avtomobil plitasi. Brend \"Gentra\" nomini ikki xil avtomobilda ishlatgan — 2005 yildan 2011 yilgacha Janubiy Koreyada sotilgan kichik ixcham model va 2013 yildan beri O'zbekistonda Uz—Daewoo Auto tomonidan taqdim etilgan ixcham avtomobil. O'zbek avtomobili 2015 yilda Ravon Gentra deb o'zgartirildi.\uD83E\uDD11Narxi 114 449 000 сум до 138 126 000 сум.");
                    sendPhoto.setPhoto(new InputFile("https://www.avtogide.ru/wp-content/uploads/2017/09/2.jpeg"));


                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }

                } else if (text.equals("malibu")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Avtomobil 2,4 litr hajmli, toʻrt silindrli 169 va 263 ot kuchi quvvatiga ega mexanik va avtomat uzatmali dvigatel bilan jihozlangan. Ushbu modelda rul boshqaruvining yaxshilangani avtomobilning haydovchi harakatiga nisbatan tez va aniq reaksiyasini taʼminlaydi, izolatsiya qilingan oldingi rama shovqin va vibratsiyaning salonga kirishiga yoʻl qoʻymaydi. „Malibu“ kuzovi konstruksiyasi mustahkam ishlangani avtomobilni yuqori tezlikda boshqarishda qoʻshimcha qulaylik yaratadi.\uD83E\uDD11Narxi Malibu XL 1LT  334 822 000 so‘m.");
                    sendPhoto.setPhoto(new InputFile("https://5dac52c76df608985c24-7d2c735e92bff83dac4bd89f26cc082d.ssl.cf1.rackcdn.com/1G1ZD5ST4KF204485/d52a261de8e2ec4e2dc7f258931fd715.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("trekkir")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("aralash tsiklida tejamkor yoqilg'i iste'mol 6,9 l/100 km, shahar toshqorisidagi yo'lda shvarlanish-5,6 l/100 km; Xatarlar;  past tezlikli avtomatik tormoz Cutter checker  joylarcomment favqulodda tormozlash.\uD83E\uDD11Narxi Tracker 2 primier. 266 737 600 сум");
                    sendPhoto.setPhoto(new InputFile("https://a.d-cd.net/g8LSm-6UFdUbj2zjvwhUsCXbyq4-1920.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("kaptiva")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Avtomobil markasi Chevrolet Model Captiva Kuzov turi5 eshik SUV Eshiklar soni O'rinlar soni5/7 Kengligi nometall bilan Eng 1850 mm Uzunlik 4635 mm Balandlik 1755 mm G'ildirak 2705 mm Front iz 1562 mm Orqa iz 1572 mm Trunk hajmi eng kam 465 l Tanasi maksimal miqdori 930 l Oshkoralik200 mm.\uD83E\uDD11Naexi Captiva 4, 2017. 26 000 сум");
                    sendPhoto.setPhoto(new InputFile("https://a.d-cd.net/yRKeV8TaNVsMhmm2z3Xh3_u9At0-1920.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("benz slr Mclaren")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Mercedes-Benz SLR McLaren HDK (yuqori quvvat to'plami) 2021 yil dekabr oyida McLaren Special Operations tomonidan SLR 722 GT ning yo'l versiyasi sifatida qurilgan buyurtma qilingan mashina sifatida e'lon qilingan edi.\uD83E\uDD11Narxi mersedis benz slr Mclaren 3300 CUM");
                    sendPhoto.setPhoto(new InputFile("https://sportishka.com/uploads/posts/2022-11/thumbs/1667526905_29-sportishka-com-p-mersedes-sls-maklaren-vkontakte-33.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }

                } else if (text.equals("benz F 015")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("F 015 avtonom avtomobil hisoblanadi. Mercedes - Benz rasmiy video to'liq avtomatlashtirilgan avtomobil sifatida uning F 015 ko'rsatadi. Yo'lovchi rulga tegmasdan sayohat qiladi, bundan tashqari, odam mashinaning orqa o'rindig'ida o'tiradi.\uD83E\uDD11Narxi mersni benz F 015 3600 CUM");
                    sendPhoto.setPhoto(new InputFile("https://www.carpixel.net/w/5250724fffd89e6d962841d34d93a793/mercedes-benz-f-015-luxury-in-motion-car-wallpaper-21047.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("benz AMG vision")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("AMG Vision Gran Turismo-bu birinchi Vision Gran Turismo avtomobili.[4] dizaynni haqiqatga aylantirish butun dunyo bo'ylab Mercedes-Benz dizayn studiyalariga ishonib topshirilgan.\uD83E\uDD11Narxi mersni benz AMG vision 4400 CUM");
                    sendPhoto.setPhoto(new InputFile("https://i.cenyavto.com/2022/05/XNYV.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("benz C112")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("The Mercedes-Benz C112 eksperimental edi o'rta dvigatel kontseptsiya avtomobili 1991 yilda nemis avtomobil ishlab chiqaruvchisi tomonidan qurilgan Mercedes-Benz C111 ning keyingi versiyalariga o'xshash sinov to'shagi sifatida.\uD83E\uDD11Narxi mersni benz C112 4300 CUM");
                    sendPhoto.setPhoto(new InputFile("https://million-wallpapers.ru/wallpapers/1/18/453412823818754/nezvichajna-mashina-sered-prirodi.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("benz 999 Red Gold")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Uning Mercedes-Benz SLR McLaren 999 Red Gold Dream deb nomlangan ijodi butunlay oltin bilan bezatilgan. Ekstravagant shveytsariyalik oltin SLR ustidan 30 000 soat yurib, unga 4,35 million dollar sarmoya kiritdi.\uD83E\uDD11Narxi mersni benz 999 Red Gold 55000 CUM");
                    sendPhoto.setPhoto(new InputFile("https://www.wallpaperup.com/uploads/wallpapers/2014/08/04/414671/a91308b4ec2d296407c36f5614544f88-1400.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborildi");
                    }
                } else if (text.equals("bmw i8")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Kelajak shakllanmoqda-yangi I8 to'ntarish shaklida. Verve to'liq, qiziqarli va yangi harakat aniqlash uchun tayyor. Shartsiz haydash zavqi uchun, yo'lga qadar.\uD83E\uDD11Narxi BMW i8 1600 cum");
                    sendPhoto.setPhoto(new InputFile("https://img.razrisyika.ru/kart/55/218587-bmv-i8-4.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("bmw z8")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("The Z8 a rodster tomonidan ishlab chiqarilgan nemis avtomobil ishlab chiqaruvchisi BMV 1998 yildan 2003 yilgacha. ... Dastlab Z8 1956-1959 yillarda BMV 507 ni uyg'otish va nishonlash uchun mo'ljallangan uslublar mashqlari sifatida ishlab chiqilgan.\uD83E\uDD11Narxi BMW z8 2000 SUM");
                    sendPhoto.setPhoto(new InputFile("https://www.bentleygoldcoast.com/galleria_images/5266/5266_p2_l.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("bmw 2002 Turbo")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Bu BMW 2002 Turbo haqida. Porsche 911-ning asosiy modeli texnik pasportda 130 ot kuchiga ega bo'lgan davrda, og'irligi atigi 1080 kg va quvvati 170 ot kuchiga ega bo'lgan kichik kupe avtomobil dunyosining poydevorini buzishga qaror qildi.\uD83E\uDD11Narxi BMV 2002 Turbo 2600 CUM");
                    sendPhoto.setPhoto(new InputFile("https://bmwguide.ru/wp-content/uploads/2016/11/bmw-2002-turbo-with-1m-and-m2-25.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }

                } else if (text.equals("bmw 3.0 csl")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("E9-bu 1968 yildan 1975 yilgacha ishlab chiqarilgan bir qator to'ntarish. Dastlab 2800 CS modeli sifatida chiqarilgan E9 ga asoslangan edi BMV 2000 C / 2000 CS to'rt silindrli to'ntarish BMV M30 olti silindrli dvigatelga mos ravishda kattalashtirilgan.\uD83E\uDD11Narxi BMW 3.0 csl 2800 CUM");
                    sendPhoto.setPhoto(new InputFile("https://s.mediasalt.ru/images/330/330247/original.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("bmw 1 seriyali m kupesi")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Bundan tashqari, qulaylik, xavfsizlik va ma'lumot-ko'ngilochar nuqtai nazaridan individual imtiyozlar BMV 1 seriyali kupe, shu jumladan BMV ConnectedDrive dasturi uchun mavjud bo'lgan uskunalar variantlarining modelga xos tanlovi bilan bajarilishi mumkin.\uD83E\uDD11Narxi BMW 1 seriyali m kupesi");
                    sendPhoto.setPhoto(new InputFile("https://foto.carexpert.ru/img/foto1680/bmw/bmw2461.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("kia K9")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Kia K9 premium toifasidagi biznes-sedani O‘zbekistonda ikki komplektatsiyada taqdim etilmoqda: Prestige va Premium. Hashamatli Kia K9 V6 3,3 GDI (249 ot kuchi) dvigateli, avtomat uzatmalar qutisi va to‘liq privod bilan jihozlangan.\uD83E\uDD11Narxi kia K9 32000 CUM");
                    sendPhoto.setPhoto(new InputFile("https://carsweek.ru/upload/iblock/375/37538a3d4e80608b7af6877ca09fbff2.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("kia K8")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Kia K8 Hybrid 2021-yil 4-mayda chiqarilgan boʻlib, u anʼanaviy dvigatelga qoʻshimcha ravishda 1,6 litrli turbo gibrid dvigatel, 17 dyuymli ishlov berilgan gʻildiraklar, avtomobilning elektrlashgan ekanligini bildiruvchi emblema va maxsus klasterli grafikni taqdim etadi.\uD83E\uDD11Narxi kia K8 44000 CUM");
                    sendPhoto.setPhoto(new InputFile("https://s0.rbk.ru/v6_top_pics/media/img/9/78/756164957010789.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("kia K5")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Janubiy Koreya bozorida ikkinchi avlodda avtomobil Kia Lotze va Kia K5 deb nomlandi va Magentis butun dunyo boʻylab nomga aylandi, Qoʻshma Shtatlar va Malayziyadan tashqari, Optima nomi saqlanib qoldi.\uD83E\uDD11Narxi kia K5 22000 CUM");
                    sendPhoto.setPhoto(new InputFile("https://www.carpixel.net/w/6c9f6ef24d39e3109cae7d339b688755/kia-k5-gt-line-car-wallpaper-99891.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }

                } else if (text.equals("kia EV6")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Birinchi EV6 uchun qo'llaniladigan, Kia yangi elektr-global modulli platforma (E-GMP) turli ichki tartibini beradi tekis qavat uchun imkon beradi. EV6 ning ixcham tashqi o'lchamlariga qaramay, uning 2,9 m g'ildirak bazasi ko'plab o'rta va katta suvlarga o'xshash idishni maydoniga olib keladi.\uD83E\uDD11Narxi kia EV6 41000 CUM");
                    sendPhoto.setPhoto(new InputFile("https://avtonovostidnya.ru/wp-content/uploads/2021/03/kia-ev6-1280x720.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("kia Creato")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("Kia Cerato Janubiy Koreyaning Kia Motors korporatsiyasi tomonidan ishlab chiqarilgan o'rta sinf avtomobil. Avtomobilning birinchi avlodi 2003 yilda, ikkinchisi 2008 yilda taqdim etilgan.\uD83E\uDD11Narxi kia Creato 67000 CUM");
                    sendPhoto.setPhoto(new InputFile("https://s0.rbk.ru/v6_top_pics/media/img/1/22/756183919990221.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("byd HAN")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("BYD global dizayn direktori Volfgang Jozef Egger Genesis Han EV modelini yaratishda ijodkorlik uchun javobgardir.\uD83E\uDD11Narxi byd HAN 49000 CUM");
                    sendPhoto.setPhoto(new InputFile("https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/BYD_Han_EV_CRI_01_2022_3634.jpg/1599px-BYD_Han_EV_CRI_01_2022_3634.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("byd Yuan Plus")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("BYD YUAN PLUS-bu BYD e-platformasida qurilgan birinchi A-sinf modeli 3.0, aql, samaradorlik, xavfsizlik va estetika jihatidan alohida ishlashga ega. Ushbu model yangi va jozibali Dragon Face dizayn tilini o'zida mujassam etgan.\uD83E\uDD11Narxi byd Yuan Plus 72000 CUM");
                    sendPhoto.setPhoto(new InputFile("https://autoiwc.ru/images/byd/byd-yuan-plus.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("byd E2")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("BYD E3 sedani bir xil ishlash ko'rsatkichlariga ega. Ikkala avtomobil ham ikkita batareya varianti bilan jihozlangan: 35,2 kVt⋅s quvvatga ega, NEDC tsikli bo'yicha 305 km gacha yoki 47,3 kVt⋅s quvvatga ega, xuddi shu tsikl bo'yicha 405 km masofaga ega.\uD83E\uDD11Narxi byd E2 67000 CUM");
                    sendPhoto.setPhoto(new InputFile("https://i.ytimg.com/vi/agCYxcgG_V0/maxresdefault.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }

                } else if (text.equals("byd SEAL 82.5")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("BYD muhrining barcha tafsilotlari va xususiyatlari 82,5 kVt / soat (2023). Har bir elektromobilning narxi, ijarasi, Real diapazoni va iste'molini Solishtiring.\uD83E\uDD11Narxi byd SEAL 82.5 15000 CUM");
                    sendPhoto.setPhoto(new InputFile("https://img.alicdn.com/imgextra/i4/41657833484916131/O1CN01c7H0ht1vA331eOrt1_!!41657833484916131-0-tbvideo.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }
                } else if (text.equals("byd sedan")) {
                    getBtn(chatId, "SOTIB OLISHNI ISTAYSIZMI\uD83E\uDD1D", messageId, BotConfig.SDR);
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(chatId);
                    sendPhoto.setCaption("BYD Chazor: narx va texnik xususiyatlar. BYD Chazor dmi-bu eng zamonaviy BYD texnologiyalariga asoslangan gibrid sedan.\uD83E\uDD11Narxi byd sedan 42000 CUM");
                    sendPhoto.setPhoto(new InputFile("https://carsweek.ru/upload/resize_cache/iblock/160/1200_900_1/160ef3a22e9e5fa4f8b0dcfcf70ca841.jpg"));
                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        System.err.println("rasm yuborilmadi");
                    }

                }
            }
        }
    }

    public void getBtn(String chatId, String text, Integer messageId, List<String> btns) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rows = new ArrayList<>();
        int tr = 0;
        for (int i = 0; i < btns.size() / 2; i++) {
            KeyboardRow row = new KeyboardRow();
            for (int j = 0; j < 2; j++) {
                KeyboardButton button = KeyboardButton.builder()
                        .text(btns.get(tr))
                        .build();
                row.add(button);
                tr++;
            }
            rows.add(row);
        }
        replyKeyboardMarkup.setKeyboard(rows);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        try {
            execute(
                    SendMessage.builder()
                            .chatId(chatId)
                            .text(text)
                            .replyToMessageId(messageId)
                            .replyMarkup(replyKeyboardMarkup)
                            .build()
            );
        } catch (TelegramApiException e) {
            System.err.println("Knopka ketmadi");
        }
    }


    public void sendMsg(String chatId, String text, Integer messageId) {
        try {
            execute(
                    SendMessage.builder()
                            .chatId(chatId)
                            .text(text)
                            .replyToMessageId(messageId)
                            .build()
            );
        } catch (TelegramApiException e) {
            System.err.println("Habar ketmadi");
        }
    }

}