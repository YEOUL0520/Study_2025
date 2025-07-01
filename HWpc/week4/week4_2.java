package week4;

class vidio_player {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videolen_sec = to_sec(video_len);
        int pos_sec = to_sec(pos);
        int ops_sec = to_sec(op_start);
        int ope_sec = to_sec(op_end);

        for(int i = 0; i < commands.length; i++) {
            // 현재 시간이 오프닝 구간이면 자동으로 오프닝 건너뛰기를 한다
            if(pos_sec >= ops_sec && pos_sec <= ope_sec) {
                pos_sec = ope_sec;
            }
            // prev 명령 수행
            if(commands[i].equals("prev")) {
                if(pos_sec < 10){
                    pos_sec = 0;
                }else{
                    pos_sec -= 10;
                }
            // next 명령 수행
            }else if(commands[i].equals("next")) {
                if(videolen_sec - pos_sec < 10){
                    pos_sec = videolen_sec;
                }else{
                    pos_sec += 10;
                }
            }
        }
        if(pos_sec >= ops_sec && pos_sec <= ope_sec) {
            pos_sec = ope_sec;
        }

        return to_time(pos_sec);
    }
    // 문자열인 시간을 정수형 시간으로 바꾸기
    static int to_sec(String time){
        String[] split = time.split(":");
        //parseInt 는 String타입 숫자를 int타입으로 변환해주는 것
        int min = Integer.parseInt(split[0]);
        int sec = Integer.parseInt(split[1]);
        return min *  60 + sec;
    }
    // 시간 형식으로 바꾸기
    static String to_time(int sec){
        int m = sec / 60, s = sec % 60;
        return String.format("%02d:%02d", m, s);
    }
}


public class week4_2 {
    public static void main(String[] args) {
        String vilen = "07:22";
        String pos = "04:05";
        String op_start = "00:15";
        String op_end = "04:07";
        String[] commands = {"next"};

        vidio_player vip = new vidio_player();
        System.out.println(vip.solution(vilen, pos, op_start, op_end, commands));

    }
}
