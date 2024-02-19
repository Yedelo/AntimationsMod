# AntimationsMod
ChatTriggers module: https://github.com/Yedelo/Antimations

Modrinth site: https://modrinth.com/project/antimations

Legally cancels player swings animation, both from yourself and other players

Done by resetting the swing progress for yourself to -1 after you swing. Swing progress does not affect animation/use entity packets or the hit delay. For other players, it cancels S0BPacketAnimation when the type is 0 (swing) since the client does not need to respond to these.

Example video: https://youtu.be/behmZVH4Qw0
