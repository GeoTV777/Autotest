package data.personal;

public enum CommunicationMethodData {
    VK("vk"),
    OK("ok"),
    SKYPE("skype"),
    TELEGRAM("telegram"),
    WHATSAPP("whatsapp"),
    HABR("habr");


     public String name;

      CommunicationMethodData(String name) {
          this.name=name;
      }
      public String getName() {
            return name;
       }
}

