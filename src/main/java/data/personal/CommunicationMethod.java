package data.personal;

public enum CommunicationMethod {
    VK("vk"),
    OK("ok"),
    SKYPE("skype"),
     TELEGRAM("telegram");

     public String name;

      CommunicationMethod(String name) {
          this.name=name;
      }
       public String getName() {
            return name;
       }
}

//[data-value="vk"]